/*
14. Longest Common Prefix
Easy

1240

1232

Favorite

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

*/

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ""; // At least, we have one strs[0]
        if (strs.length == 1) return strs[0]; // Missed first time

        int minLength = 1000;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        String firstString = strs[0];
        int maxCommonPrefixLength = minLength; // Missed second time

        loop2: for (int j = 0; j < minLength; j++) {
            char letter = firstString.charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != letter) {
                    maxCommonPrefixLength = j; // j-th length did not make it
                    break loop2;
                }
            }
        }
        System.out.println(maxCommonPrefixLength);
        maxCommonPrefixLength = Math.max(maxCommonPrefixLength, 0);
        return firstString.substring(0, maxCommonPrefixLength);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("###" + sol.longestCommonPrefix(new String[] { "flower","flow","flight"} ));
        System.out.println("###" + sol.longestCommonPrefix(new String[] { "dog","car","race"} ));
        System.out.println("###" + sol.longestCommonPrefix(new String[] { "a"} ));
        System.out.println("###" + sol.longestCommonPrefix(new String[] { "c","c" } )); // missed second time
    }
}

