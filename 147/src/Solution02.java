/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution02 {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0), p;
        while (curr != null) {
            p = dummy;
            while (p.next != null && curr.val > p.next.val) {
                p = p.next;
            }
            ListNode pNext = p.next;
            p.next = curr;
            ListNode next = curr.next;
            curr.next = pNext;
            curr = next;
        }
        return dummy.next;
    }
}
