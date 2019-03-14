/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 8           ===> 8
// 2 -> 6      ===> 62
// 2 -> 6 -> 8 ===> 862
// node.val + node.next.val * 10 + node.next.next.val * 100

class Solution {

    // 81 = 1 -> 8 -> nul
    long toNumber(ListNode node) {
        if (node == null) {
            return 0;
        }
        return 10 * node.val + toNumber(node.next);
    }

    // 23  ->  3 -> 2
    ListNode toList(long num) {
        int digit = num % 10;
        ListNode node = new ListNode(digit);

        long rest = num / 10;
        boolean moreDigits = rest > 0;
        if (moreDigits) {
            node.next = toList(rest);
        }
        return node;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = toNumber(l1);
        long num2 = toNumber(l2);
        long sum = num1 + num2; // sum may not fit into an int ??

        ListNode root = toList(sum);
        return root;
    }
}