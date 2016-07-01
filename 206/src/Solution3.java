/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, new ListNode(0));
    }
    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead.next;
        }
        ListNode next = head.next;
        ListNode newNext = newHead.next;
        newHead.next = head;
        head.next = newNext;
        return reverseList(next, newHead);
    }
}