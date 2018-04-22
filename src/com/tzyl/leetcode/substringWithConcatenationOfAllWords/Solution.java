/**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
package com.tzyl.leetcode.substringWithConcatenationOfAllWords;

import java.util.*;

public class Solution {
    /**
     * Finds all start indexes of substrings in s that are a concatenation of each word in words exactly once. Each word
     * in words must be the same length.
     * @param s the string to find substring in
     * @param words the words of same length that the string must be a concatenation of
     * @return the list of all possible starting indexes
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> solution = new ArrayList<>();
        if (words == null || words.length == 0) {
            return solution;
        }

        int n = s.length();
        int m = words[0].length();
        for (String word : words) {
            if (word.length() != m) {
                // throw new IllegalArgumentException("words must all be the same length");
                return solution;
            }
        }
        if (n < m * words.length) {
            // throw new IllegalArgumentException("string is not long enough to contain a substring with all words");
            return solution;
        }

        Map<Integer, String> appearances = findAppearances(s, words);
        for (int i = 0; i < words[0].length(); i++) {
            solution.addAll(findSubstringOffset(s, words, appearances, i));
        }
        return solution;
    }

    /**
     * Finds solution for indexes at an offset. The offset allows us to efficiently track a rolling window using the
     * precomputed appearances map to work out if we cover all words exactly once.
     * @param s the string to find substring in
     * @param words the words that the string must be a concatenation of
     * @param appearances the precomputed map between indexes in the string and what word appears there
     * @param offset the possible solution index modulo length of a word will be equal to offset
     * @return the list of all possible starting indexes at an offset
     */
    private static List<Integer> findSubstringOffset(String s, String[] words, Map<Integer, String> appearances,
                                                     int offset) {
        List<Integer> solution = new ArrayList<>();
        Counter counter = new Counter(words);
        // Map<String, Integer> counter = new HashMap<>();
        // int wordCount = 0;
        int n = s.length();
        int m = words[0].length();

        // Calculate words seen in initial position.
        for (int i = 0; i < words.length; i++) {
            int currentWordIndex = offset + i * m;
            if (appearances.containsKey(currentWordIndex)) {
                counter.addWord(appearances.get(currentWordIndex));
            }
        }

        // For each position check if we cover all words.
        int maxNumberOfWords = n / m;
        for (int i = 0; i < maxNumberOfWords - words.length + 1; i++) {
            if (counter.check()) {
                solution.add(offset + i * m);
            }
            if (i < maxNumberOfWords - words.length) {
                int oldWordIndex = offset + i * m;
                if (appearances.containsKey(oldWordIndex)) {
                    counter.removeWord(appearances.get(oldWordIndex));
                }
                int newWordIndex = offset + (i + words.length) * m;
                if (appearances.containsKey(newWordIndex)) {
                    counter.addWord(appearances.get(newWordIndex));
                }
            }
        }

        return solution;
    }

    /**
     * Finds the indexes of appearances of words in the string.
     * @param s the string to find words in
     * @param words the words of same length to find in the string
     * @return the map from an index to the word starting at that index
     */
    private static Map<Integer,String> findAppearances(String s, String[] words) {
        Map<Integer, String> appearances = new HashMap<>();
        int n = s.length();
        int m = words[0].length();

        Map<Integer, Integer> hashes = calculateRollingHashes(s, m);
        Map<Integer, List<String>> targets = new HashMap<>();
        Arrays.stream(words)
                .forEach(word -> {
                    int hash = calculateRollingHashes(word, m).get(0);
                    if (targets.containsKey(hash)) {
                        targets.get(hash).add(word);
                    } else {
                        List<String> targetWords = new ArrayList<>();
                        targetWords.add(word);
                        targets.put(hash, targetWords);
                    }
                });

        for (int i = 0; i < n - m + 1; i++) {
            int index = i;
            int hash = hashes.get(i);
            if (targets.containsKey(hash)) {
                String current = s.substring(i, i + m);
                targets.get(hash).stream()
                        .filter(word -> word.equals(current))
                        .findFirst()
                        .ifPresent(word -> appearances.put(index, word));
            }
        }

        return appearances;
    }


    /**
     * Calculates the rolling hash of substrings of length m in the string s.
     * @param s the string to calculate rolling hashes from
     * @param m the length of substrings to calculate rolling hashes of
     * @return the map between starting indexes of substrings and the corresponding rolling hash
     */
    private static Map<Integer, Integer> calculateRollingHashes(String s, int m) {
        int n = s.length();
        if (n < m) {
            throw new IllegalArgumentException("length of substring must be less than or equal to length of string");
        }

        int q = 101;
        int h = modPow(256, m - 1, q);
        int rollingHash = 0;

        // Calculate initial hash
        for (int i = 0; i < m; i++) {
            rollingHash = (256 * rollingHash + s.charAt(i)) % q;
        }

        // Calculate rolling hashes
        Map<Integer, Integer> hashes = new HashMap<>();
        for (int i = 0; i < n - m + 1; i++) {
            hashes.put(i, rollingHash);
            if (i < n - m) {
                rollingHash = (256 * (rollingHash - h * s.charAt(i)) + s.charAt(i + m)) % q;
                // Enforce positive
                rollingHash = (rollingHash + q) % q;
            }
        }
        return hashes;
    }

    /**
     * Calculates (x^y) % z
     */
    private static int modPow(int x, int y, int z) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = ((result * x) % z);
        }
        return result;
    }
}

/**
 * Tracks count of words in current substring and whether all words are covered exactly once.
 */
class Counter {
    private final String[] words;
    private final Map<String, Integer> counter = new HashMap<>();
    private final Map<String, Integer> targetCounter = new HashMap<>();

    private final Map<String, Integer> order = new HashMap<>();
    private final BitSet checker = new BitSet();

    public Counter(String[] words) {
        this.words = words;
        int i = 0;
        for (String word : words) {
            int count = targetCounter.getOrDefault(word, 0);
            targetCounter.put(word, count + 1);
            if (!order.containsKey(word)) {
                order.put(word, i);
                i++;
            }
        }
    }

    public void addWord(String word) {
        if (!order.containsKey(word)) {
            throw new IllegalArgumentException("word not in list of words to count");
        }

        int newCount = counter.getOrDefault(word, 0) + 1;
        counter.put(word, newCount);

        // Only set checker bit if we are on the target count for this word.
        checker.clear(order.get(word));
        if (newCount == targetCounter.get(word)) {
            checker.set(order.get(word));
        }
    }

    public void removeWord(String word) {
        if (!order.containsKey(word)) {
            throw new IllegalArgumentException("word not in list of words to count");
        }

        int newCount = counter.getOrDefault(word, 0) - 1;
        if (newCount == -1) {
            throw new IllegalArgumentException("can't remove word that is not in current window");
        }
        counter.put(word, newCount);

        // Only set checker bit if we are on the target count for this word.
        checker.clear(order.get(word));
        if (newCount == targetCounter.get(word)) {
            checker.set(order.get(word));
        }
    }

    public boolean check() {
        return checker.cardinality() == order.size();
    }
}
