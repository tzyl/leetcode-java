/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
package com.tzyl.leetcode.romanToInt;

import java.util.HashMap;

public class Solution {
    private static final HashMap<Character, Integer> symbolToValue;

    static {
        symbolToValue = new HashMap<>();
        symbolToValue.put('I', 1);
        symbolToValue.put('V', 5);
        symbolToValue.put('X', 10);
        symbolToValue.put('L', 50);
        symbolToValue.put('C', 100);
        symbolToValue.put('D', 500);
        symbolToValue.put('M', 1000);
    }

    public int romanToInt(String s) {
        int converted = 0;
        int prevSymbolValue = 1000;
        for (char c : s.toCharArray()) {
            int symbolValue = symbolToValue.get(c);
            converted += symbolValue;
            if (symbolValue > prevSymbolValue) {
                converted -= 2 * prevSymbolValue;
            }
            prevSymbolValue = symbolValue;
        }
        return converted;
    }
}
