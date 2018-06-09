#!/usr/bin/env bash
set -euo pipefail
IFS=$'\n\t'

if [[ $# -eq 0 ]]; then
  echo "Usage: ./initialize_docstring.sh <problem_id>"
  exit 1
fi
PROBLEM_ID=$1

COOKIE_FILE="cookies.txt"
trap "rm -f $COOKIE_FILE" EXIT

echo "Getting CSRF token"
curl -c $COOKIE_FILE --silent "https://leetcode.com" &>/dev/null
CSRF_TOKEN=$(grep -E 'csrftoken\t\w+' $COOKIE_FILE -o | cut -d $'\t' -f2)

echo "Getting all problems"
PROBLEMS=$(curl --silent https://leetcode.com/api/problems/all/  -H "cookie:  csrftoken=$CSRF_TOKEN" -H "content-type: application/json" -H "accept: application/json" -H "authority: leetcode.com" -H "referer: https://leetcode.com" --compressed)

echo "Getting title slug of problem $PROBLEM_ID"
TITLE_SLUG=$(echo $PROBLEMS | jq -r ".stat_status_pairs | map(select(.stat.frontend_question_id == $PROBLEM_ID)) | .[0]? | .stat.question__title_slug")

if [[ -z $TITLE_SLUG || $TITLE_SLUG = "null" ]]; then
  echo "Unable to find problem with ID: $PROBLEM_ID"
  exit 1
fi
echo "Found problem title slug: $TITLE_SLUG"

echo "Getting problem details for problem $PROBLEM_ID, $TITLE_SLUG"
PROBLEM=$(curl --silent "https://leetcode.com/graphql" -H "cookie:  csrftoken=$CSRF_TOKEN" -H "x-csrftoken: $CSRF_TOKEN" -H "content-type: application/json" -H "accept: application/json" -H "authority: leetcode.com" -H "referer: https://leetcode.com/" -d "{\"operationName\":\"getQuestionDetail\",\"variables\":{\"titleSlug\":\"$TITLE_SLUG\"},\"query\":\"query getQuestionDetail(\$titleSlug: String!) {\n  question(titleSlug: \$titleSlug) {\n    questionId\n    questionFrontendId\n    questionTitle\n    content\n  }\n}\n\"}")

echo
echo "Problem description docstring:"
echo

PROBLEM_TITLE=$(echo $PROBLEM | jq -r '.data.question.questionTitle')
PROBLEM_DESCRIPTION=$(echo $PROBLEM | jq -r '.data.question.content' | sed -e 's/<[^>]*>//g')

echo "/**"
echo " * $PROBLEM_ID. $PROBLEM_TITLE"
echo " *"
for line in $PROBLEM_DESCRIPTION; do
  echo " * $line"
done
echo " */"

