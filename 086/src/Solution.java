/**
 * Created by yunxiaozou on 5/14/16.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy2 = new ListNode(0);
        ListNode curr2 = dummy2;
        ListNode curr = dummy;
        while (curr.next != null) { //use curr as prev.
            ListNode next = curr.next;
            if (next.val < x) {
                curr.next = next.next;
                curr2.next = next;
                next.next = null;
                curr2 = curr2.next;
            } else {
                curr = curr.next;
            }
        }
        curr2.next = dummy.next;
        return dummy2.next;

    }
}