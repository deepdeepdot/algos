// Easy
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> chars = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isClosing = ")}]".contains(""+ch);
            boolean isStarting = "({[".contains(""+ch);

            if (!isStarting && !isClosing) return false;
            if (isStarting) {
                chars.push(ch);
            } else if (isClosing) {
                if (chars.empty()) return false;
                char open = chars.pop();
                // Matching pairs?
                boolean match =
                    (open == '{' && ch == '}') ||
                    (open == '(' && ch == ')') ||
                    (open == '[' && ch == ']');
                if (!match) return false;
            }
        }
        return chars.empty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));
    }
}

