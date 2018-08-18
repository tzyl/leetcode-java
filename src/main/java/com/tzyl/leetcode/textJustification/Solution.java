/**
 * 68. Text Justification
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 *
 * Example 3:
 *
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 */
package com.tzyl.leetcode.textJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public enum JUSTIFICATION_TYPE {
        LEFT,
        BOTH,
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> unjustified = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int length = 0;
        for (String word : words) {
            if (length + word.length() + currentLine.size() <= maxWidth) {
                // Add word to current line
                currentLine.add(word);
                length += word.length();
            } else {
                // Start new line
                unjustified.add(currentLine);
                currentLine = new ArrayList<>();
                currentLine.add(word);
                length = word.length();
            }
        }
        // Add last line if there are any words
        if (currentLine.size() > 0) {
            unjustified.add(currentLine);
        }

        List<String> justified = new ArrayList<>();
        for (int i = 0; i < unjustified.size(); i++) {
            List<String> line = unjustified.get(i);
            if (i == unjustified.size() - 1 || line.size() == 1) {
                justified.add(justify(line, maxWidth, JUSTIFICATION_TYPE.LEFT));
            } else {
                justified.add(justify(line, maxWidth, JUSTIFICATION_TYPE.BOTH));
            }
        }
        return justified;
    }

    private String justify(List<String> words, int width, JUSTIFICATION_TYPE type) {
        StringBuilder line = new StringBuilder();

        if (type == JUSTIFICATION_TYPE.LEFT) {
            int length = 0;
            // Add words left justified
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                line.append(word);
                length += word.length();
                if (i != words.size() - 1) {
                    line.append(" ");
                    length++;
                }
            }
            // Pad remaining width
            for (int i = length; i < width; i++) {
                line.append(" ");
            }
        } else if (type == JUSTIFICATION_TYPE.BOTH) {
            int remainingWhitespace = width - words.stream().mapToInt(String::length).sum();
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                line.append(word);
                // Spread whitespace evenly with any extra going to the spaces on the left
                if (i != words.size() - 1) {
                    int remainingGaps = (words.size() - i - 1);
                    int whitespace = (remainingWhitespace + (remainingGaps - 1)) / remainingGaps;
                    for (int j = 0; j < whitespace; j++) {
                        line.append(" ");
                    }
                    remainingWhitespace -= whitespace;
                }
            }
        }

        return line.toString();
    }
}
