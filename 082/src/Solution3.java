/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null) {
            ListNode curr = prev.next;
            if (curr.next == null || curr.val != curr.next.val) {
                prev = curr;
            } else {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                prev.next = curr;
            }
        }
        return dummy.next;
    }
}