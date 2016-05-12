/**
 * Created by yunxiaozou on 5/12/16.
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0), tail = sentinel;
        for (ListNode node = head, prev = null; node != null; prev = node, node = node.next) {
            if ((prev == null || prev.val != node.val) && (node.next == null || node.next.val != node.val)) {
                tail.next = node;
                tail = node;
            }
        }
        tail.next = null;
        return sentinel.next;
    }
}
