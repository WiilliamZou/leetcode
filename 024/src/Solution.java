/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = head.next;
        ListNode p;
        ListNode q;
        p = head;
        while (p != null && p.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = p;
            p = p.next;
        }
        return result;
    }
}