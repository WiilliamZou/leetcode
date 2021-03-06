/**
 * Created by yunxiaozou on 4/13/16.
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode end;
        ListNode next;
        dummy.next = curr;
        while (true) {
            int count = k;
            end = curr;
            while (count != 1 && end != null) {
                count--;
                end = end.next;
            }
            if (end == null) {
                return dummy.next;
            }

            while (prev.next != end) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}
