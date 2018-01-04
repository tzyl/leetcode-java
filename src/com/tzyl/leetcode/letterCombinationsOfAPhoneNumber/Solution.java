/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package com.tzyl.leetcode.letterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

class Solution {
    static String[] digitToCharacters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> combinations = new LinkedList<>();
        if (digits.isEmpty()) return combinations;
        combinations.add("");
        for (int i = 0; i < digits.length(); i++) {
            // Use null as a marker for when we have created all combinations of a particular length.
            combinations.add(null);
            String current = combinations.remove();
            while (current != null) {
                for (char c : digitToCharacters[digits.charAt(i) - '0'].toCharArray()) {
                    combinations.add(current + c);
                }
                current = combinations.remove();
            }
        }
        return combinations;
    }
}