/**
 * Created by yunxiaozou on 5/14/16.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode lessHead = new ListNode(0);
        ListNode lessP = lessHead;
        ListNode p = fakeHead;
        while (p.next != null) {
            ListNode next = p.next;
            if (next.val < x) {
                p.next = next.next;
                lessP.next = next;
                next.next = null;
                lessP = lessP.next;
            } else {
                p = p.next;
            }
        }
        lessP.next = fakeHead.next;
        return lessHead.next;

    }
}