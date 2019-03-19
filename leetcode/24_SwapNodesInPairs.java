/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        boolean pairExists = head != null && head.next != null;
        if (pairExists) {
            // We have something to swap; otherwise skip swap
            ListNode first = head.next;
            ListNode second = head;
            ListNode last = head.next.next;
            first.next = second;
            second.next = swapPairs(last);
            return first;
        }
        return head; // could be null or a single item
    }
}