/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
    /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode remain, ListNode newHead) {
        if (remain == null)
            return newHead;
        ListNode next = remain.next;
        remain.next = newHead;
        return reverseListInt(next, remain);
    }

}
