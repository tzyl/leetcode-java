/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
package com.tzyl.leetcode.zigZagConversion;


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            rows[rowIndex] = new StringBuilder();
        }
        int row = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            rows[row].append(s.charAt(i));
            row += direction;
            if (row == 0 || row == numRows - 1) direction *= -1;
        }
        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            rows[0].append(rows[rowIndex]);
        }
        return rows[0].toString();
    }
}