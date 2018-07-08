/**
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 */
package com.tzyl.leetcode.lengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        // Trim whitespace
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex <= endIndex && s.charAt(startIndex) == ' ') {
            startIndex++;
        }
        while (endIndex >= startIndex && s.charAt(endIndex) == ' ') {
            endIndex--;
        }
        // Find last space
        int lastSpace = -1;
        for (int i = 0; i < endIndex - startIndex + 1; i++) {
            if (s.charAt(startIndex + i) == ' ') {
                lastSpace = i;
            }
        }
        return endIndex - startIndex - lastSpace;
    }
}
