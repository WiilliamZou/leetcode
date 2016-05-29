/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummy = new ListNode(0);
        ListNode curr = node;
        ListNode prev = dummy;
        dummy.next = node;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr == node) {
                prev.next = next;
                curr.next = null;
            } else {
                prev = curr;
            }
            curr = next;
        }

    }
}