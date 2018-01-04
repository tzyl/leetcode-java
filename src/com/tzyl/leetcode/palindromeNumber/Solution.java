/**
 * 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 */
package com.tzyl.leetcode.palindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!= 0 && x % 10 == 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        // reversed / 10 for odd number of digits.
        return x == reversed || x == reversed / 10;
    }
}