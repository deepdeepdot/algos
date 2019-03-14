/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {

    String[] getMaxCandidates(String s) {
        int len = s.length();
        String[] maxCandidates = new String[len];

        // Compute initial upper bound for each letter
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            int runLength = 1;
            for (int j = i+1; j < len; j++) {
                if (s.charAt(j) == current) {
                    break;
                }
                runLength += 1;
            }
            maxCandidates[i] = s.substring(i, i + runLength);
        }
        return maxCandidates;
    }

    String getLongestSubstring(String s) {
        Set<Character> letters = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (letters.contains(ch)) {
                return s.substring(0, i);
            }
            letters.add(ch);
        }
        return s;
    }

    public int lengthOfLongestSubstring(String s) {
        String[] maxCandidates = getMaxCandidates(s);
        String[] maxSubstrings = new String[s.length()];

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            maxSubstrings[i] = getLongestSubstring(maxCandidates[i]);
            maxLength = Math.max(maxLength, maxSubstrings[i].length());
        }
        return maxLength;
    }
}
