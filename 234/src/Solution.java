/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        slow = reverse(slow);
        while (head != null && slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode node) {
        ListNode pre = new ListNode(0);
        while (node != null) {
            ListNode next = node.next;
            node.next = pre.next;
            pre.next = node;
            node = next;
        }
        return  pre.next;
    }
}