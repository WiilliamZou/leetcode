public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        if (k < 1) return head;
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            length++;
            last = last.next;
        }
        k  = k % length;
        k--;
        ListNode p1 = head;
        ListNode p2 = head;
        return null;
    }
}