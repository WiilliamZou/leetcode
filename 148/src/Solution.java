/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow, fast, p;
        slow = fast = head;
        p = null;
        while (fast != null && fast.next != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        p.next = null;
        head = sortList(head);
        slow = sortList(slow);
        return merge(head, slow);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1, p2, p;
        ListNode dummy = new ListNode(0);

        p1 = l1;
        p2 = l2;
        p = dummy;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                p.next = p1;
                p1 = p1.next;
            } else {
                if (p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                }else {
                    p.next = p1;
                    p1 = p1.next;
                }
            }
            p = p.next;
        }
        return dummy.next;

    }
}