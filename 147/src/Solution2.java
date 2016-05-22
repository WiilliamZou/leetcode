/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0), p;
        while (cur != null) {
            //locate the insertion position.
            p = dummy;
            while (p.next != null &&  cur.val > p.next.val) {
                p = p.next;
            }
            //insert between p and p.next.
            ListNode pNext = p.next;
            p.next = cur;
            ListNode next = cur.next;
            cur.next = pNext;
            cur = next;
        }
        return dummy.next;
    }
}
