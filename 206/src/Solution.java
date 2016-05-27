/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode c = head;
        while (c != null) {
            ListNode next = c.next;
            c.next = dummy.next;
            dummy.next = c;
            c = next;
        }
        return dummy.next;
    }
}