import java.util.*;

class Solution {
    /*
      Greedy approach:
        Start in the middle and keep expanding east/west to collect the longest substring
        Once we find the largest middle,
            if len(middle) > 1/2, return length (others cannot be larger)
            else keep looking in each half with center at 'repeated' char
        
        Solution: (0-length)
        -> Any fast test to check for each length?

        -> Observation:
        -> If there's a solution > length/2, then the middle character is included,
           sort of like the pidgeon hole
     */

    // Modification: find the largest with duplicates at each end
    // -> Traverse each side for longer side

    String getLargestMiddleFromRight(String s) {
        Set<Character> letters = new HashSet<Character>();
        int len = s.length();
        int start = s.length() / 2;
        int left = start;
        int right = start;

        boolean keepGoingLeft = true;
        boolean keepGoingRight = true;
        letters.add(s.charAt(start));

        for (int i = 0; i < len/2; i++) {
            if (keepGoingRight) {
                char ch = s.charAt(right+1); // peek
                if (!letters.contains(ch)) {
                    letters.add(ch);
                    right = right+1;
                } else {
                    keepGoingRight = false;
                }
                if (right == len-1) {
                    keepGoingRight = false;
                }
            }
            if (keepGoingLeft) {
                char ch = s.charAt(left-1); // peek
                if (!letters.contains(ch)) {
                    left = left-1;
                    letters.add(ch);
                } else {
                    keepGoingLeft = false;
                }
                if (left == 0) {
                    keepGoingLeft = false;
                }
            }
            if (!keepGoingLeft && !keepGoingRight) {
                break;
            } 
        }
        return s.substring(left, right+1);
    }


    String getLargestMiddleFromLeft(String s) {
        Set<Character> letters = new HashSet<Character>();
        int len = s.length();
        int start = s.length() / 2;
        int left = start;
        int right = start;

        boolean keepGoingLeft = true;
        boolean keepGoingRight = true;
        letters.add(s.charAt(start));

        for (int i = 0; i < len/2; i++) {
            if (keepGoingLeft) {
                char ch = s.charAt(left-1); // peek
                if (!letters.contains(ch)) {
                    left = left-1;
                    letters.add(ch);
                } else {
                    keepGoingLeft = false;
                }
                if (left == 0) {
                    keepGoingLeft = false;
                }
            }
            if (keepGoingRight) {
                char ch = s.charAt(right+1); // peek
                if (!letters.contains(ch)) {
                    letters.add(ch);
                    right = right+1;
                } else {
                    keepGoingRight = false;
                }
                if (right == len-1) {
                    keepGoingRight = false;
                }
            }
            if (!keepGoingLeft && !keepGoingRight) {
                break;
            } 
        }
        return s.substring(left, right+1);
    }

    String getLargestMiddle(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        if (len == 2) {
            return s.charAt(0) == s.charAt(1) ?
                s.substring(0, 1) : s;
        }
        String right = getLargestMiddleFromRight(s);
        String left = getLargestMiddleFromLeft(s);

        if (right.length() > left.length())
            return right;
        else
            return left;
     }

    // abcabcbb
    // aab
    // brnk
    // abba

    // bpfbhmipx

    // hkcpmprxxxqw

    public int lengthOfLongestSubstring(String s) {
        String middle = getLargestMiddle(s);
        if (middle.length() >= s.length()/2) {
            return middle.length();
        }
        int start = s.indexOf(middle);
        int end = s.lastIndexOf(middle);
        int right = lengthOfLongestSubstring(s.substring(0, end));
        int left = lengthOfLongestSubstring(s.substring(start, s.length()));
        return Math.max(right, left);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.getLargestMiddle("abcabcbb"));
        System.out.println(sol.getLargestMiddle("brnk"));
        System.out.println(sol.getLargestMiddle("aab"));
        System.out.println(sol.getLargestMiddle("abba"));

        System.out.println(sol.getLargestMiddle("bpfbhmipx"));        

        System.out.println(sol.getLargestMiddle("hkcpmprxxxqw"));        

    }
}

