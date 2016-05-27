/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode c = dummy.next;
        ListNode p = dummy;
        while (c != null) {
            if (c.val == val) {
                p.next = c.next;
                c = c.next;
            } else {
                p = c;
                c = c.next;
            }
        }
        return dummy.next;
    }
}