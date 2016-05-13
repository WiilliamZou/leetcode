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
        if (head == null) return head;
        ListNode current = head;
        while(current.next != null) {
            ListNode next = current.next;
            if (current.val == next.val) {
                current.next = next.next;
            } else {
                current = next;
            }
        }
        return head;
    }
}