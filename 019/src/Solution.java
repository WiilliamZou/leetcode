

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while (p != null && n != 0){
            p = p.next;
            n--;
        }
        if (p == null) {
            return head.next;
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }
}