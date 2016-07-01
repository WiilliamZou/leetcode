/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode curr) {
        if (curr == null || curr.next == null) return curr;
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return fakeHead.next;

    }
}