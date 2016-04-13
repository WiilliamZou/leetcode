/**
 * Created by yunxiaozou on 4/13/16.
 */
public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (head != null && head.next != null) {
            temp.next = head.next;
            head.next = head.next.next;
            temp.next.next = head;
            temp = head;
            head = head.next;
        }
        return dummy.next;
    }
}
