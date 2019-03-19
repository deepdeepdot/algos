/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.*;

class Solution {
    String repeat(String pattern, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += pattern;
        }
        return result;
    }

    public String intToRomanDigit(int num, String unit, String five, String ten) {
        if (num == 0) return "";

        String romanDigit = "";
        int lastDigit = num % 10;

        if (lastDigit < 4) {
            romanDigit = repeat(unit, lastDigit);
        } else if (lastDigit == 4) {
            romanDigit = unit + five;
        } else if (lastDigit == 9) {
            romanDigit = unit + ten;
        } else {
            romanDigit = five;
            int diff5 = lastDigit - 5;
            if (diff5 == -1) romanDigit = unit + romanDigit;
            if (diff5 > 0) romanDigit = romanDigit + repeat(unit, diff5);
        }
        return romanDigit;
    }

    public String intToRoman(int num) {
        String digit1 = intToRomanDigit(num, "I", "V", "X");
        String digit2 = intToRomanDigit(num/10, "X", "L", "C");
        String digit3 = intToRomanDigit(num/100, "C", "D", "M");
        String digit4 = intToRomanDigit(num/1000, "M", "", "");

        System.out.println(digit1);
        System.out.println(digit2);
        return digit4 + digit3 + digit2 + digit1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String roman = sol.intToRoman(10);
        System.out.println(roman);
    }
}
