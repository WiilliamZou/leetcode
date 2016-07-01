public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode newHead = head;

        int len = 1;
        while (newHead.next != null) {
            newHead = newHead.next;
            len++;
        }

        newHead.next = head;
        for (int i = 1; i < len- k%len; i++) {
            head = head.next;
        }
        //for (int i = len - k % len; i > 1; i--)
        //  head = head.next;

        newHead = head.next;
        head.next = null;

        return newHead;
    }
}