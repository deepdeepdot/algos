/**
 * Definition for singly-linked list.
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean overflow) {
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (overflow? 1 : 0);
            ListNode node = new ListNode(sum % 10);
            node.next = addTwoNumbers(l1.next, l2.next, sum > 9);
            return node;
        }
        if (overflow) {
            // overflow case, with one of the list as empty
            return addTwoNumbers(l1 != null? l1: l2, new ListNode(0), overflow);
        }
        return l1 != null? l1 : l2;
    }
}

/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    ListNode addTwoNumbers(ListNode l1, ListNode l2, int overflow) {
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            ListNode node = new ListNode(sum % 10);
            node.next = addTwoNumbers(l1.next, l2.next, (sum / 10));
            return node;
        }
        return addTwoNumbers(l1 != null? l1 : l2, new ListNode(0), overflow); // shortcut of code below

        if (overflow == 0) {
            return l1 != null? l1 : l2; // shortcut of code below
            // if (l1 == null && l2 == null) {
            //     return null;
            // }
            // if (l1 == null) {
            //     return l2;
            // }
            // if (l2 == null) {
            //     return l1;
            // }
        }
        // overflow case, with one of the list as empty
        return addTwoNumbers(l1 != null? l1: l2, new ListNode(0), overflow); // shortcut of code below
        // if (l1 != null) {
        //     return addTwoNumbers(l1, new ListNode(0), overflow);
        // } else if (l2 != null) {
        //     return addTwoNumbers(l2, new ListNode(0), overflow);
        // }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
}

*/