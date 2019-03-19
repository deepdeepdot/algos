# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pairExists = head != None and head.next != None
        if pairExists: # we have something to swap; otherwise skip swap
            first = head.next
            second = head
            last = head.next.next
            first.next = second
            second.next = swapPairs(self, last)
            return second

        return head # could be null or a single item