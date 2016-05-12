/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        while(prev.next != null) {
            ListNode current = prev.next;
            if (current.next != null && current.val == current.next.val) {
                ListNode next = current;
                while (next != null && next.val == current.val) {
                    next = next.next;
                }
                prev.next = next;
            } else {
                prev = current;
            }
        }
        return fakeHead.next;
    }
}