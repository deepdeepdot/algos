/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

import java.util.*;

class Solution {

    // Duplicate mini-permutations!
    int[] subSelection(int[] source, int removedIdx) {
        int[] result = new int[source.length-1];
        int j = 0;
        for (int i = 0; i < source.length; i++) {
            if (i != removedIdx) {
                result[j++] = source[i];
            }
        }
        // More optimized, but indexes are tricky to get right, code is not clear
        // if (removedIdx > 0) {
        //     System.arraycopy(source, 0, result, 0, removedIdx);
        // }
        // if (removedIdx != source.length-1) {
        //     int len = source.length-removedIdx-1;
        //     System.arraycopy(source, removedIdx+1, result, removedIdx, len);
        // }
        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (nums.length == 0) {
            return list;
        }
        if (nums.length == 1) {
            List<Integer> values = new LinkedList<>();
            values.add(nums[0]);
            list.add(values);
            return list;
        }

        // nums.length > 1
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int[] rest = subSelection(nums, i);
            List<List<Integer>> permutations = permute(rest);

            for (List<Integer> queue: permutations) {
                ((Deque)queue).addFirst(first);
                list.add(queue);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        Solution sol = new Solution();

        int[] sub = sol.subSelection(nums, 0);

        for (int elt: sub) {
            System.out.println(elt);
        }
    }
}
