/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    ListNode reverse(ListNode node, int k) {
        if (node == null || k < 1) return null;

        ListNode[] nodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = node;
            node = node.next;
        }
        for (int i = k-1; i > 0; i--) {
            nodes[i].next = nodes[i-1];
        }
        nodes[0].next = null; // cleanup: avoid infinite loops
        return nodes[nodes.length-1];
    }

    ListNode skipKNodes(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next; // safe since countK() guarantees k+1 nodes
        }
        return node;
    }

    int countK(ListNode head, int k) {
        int count = 0;
        while (head != null && count < k) {
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = countK(head, k);
        if (count == k) {
            ListNode kNode = skipKNodes(head, k);
            ListNode root = reverse(head, k);
            // IMPORTANT: do this as the last step!
            head.next = reverseKGroup(kNode, k);
            return root;
        }
        return head;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        node = sol.reverseKGroup(node, 3);
        sol.printList(node);
    }
}
