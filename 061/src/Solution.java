public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode newHead = head;
        int length = 1;
        while(newHead.next != null) {
            length++;
            newHead = newHead.next;
        }
        newHead.next = head;
        for (int i = length - k%length; i > 1; i--) {
            head = head.next;
        }
        newHead = head.next;
        head.next = null;
        return newHead;
    }
}