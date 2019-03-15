/*

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*/

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class Solution {

    int getMinimumIdx(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIdx = i;
            }
        }
        return minIdx;
    }

    boolean hasElements(ListNode[] lists) {
        boolean has = false;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                has = true;
                break;
            }
        }
        return has;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Stack<ListNode> nodes = new Stack<ListNode>();
        ListNode sorted = null;

        while (hasElements(lists)) {
            // Get the minimum node
            int minIdx = getMinimumIdx(lists);
            ListNode minNode = lists[minIdx];
            // System.out.println("Inserting...." + minNode.val);
            nodes.push(minNode);

            // Remove the minimum node
            lists[minIdx] = lists[minIdx].next;
        }

        if (!nodes.empty()) {
            ListNode last = nodes.pop();
            // System.out.println("Pop: " + last.val);
            last.next = null;
            sorted = last;
        }

        while (!nodes.empty()) {
            ListNode previous = sorted;
            sorted = nodes.pop();
            // System.out.println("Pop: " + sorted.val);
            sorted.next = previous;
        }
        return sorted;
    }

    void print(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static void main(String[] args) {
        ListNode[] input = new ListNode[3];
        input[0] = new ListNode(1);
        input[0].next = new ListNode(4);
        input[0].next.next = new ListNode(5);

        input[1] = new ListNode(1);
        input[1].next = new ListNode(3);
        input[1].next.next = new ListNode(4);

        input[2] = new ListNode(2);
        input[2].next = new ListNode(6);

        Solution sol = new Solution();
        // sol.print(input[0]);
        // sol.print(input[1]);
        // sol.print(input[2]);
        ListNode merged = sol.mergeKLists(input);
        sol.print(merged);

        System.out.println("hasElements: " + sol.hasElements(input));
    }
}

/*

Pick n at a time from each list
Sort them (linear sort?) and insert them to the stack
-> Build the result list (backwards)

*/