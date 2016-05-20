/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
        }while( slow != null && fast != null && slow != fast);
        if (slow == null || fast == null) return null;
        ListNode slow2 = head;
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;

    }
}