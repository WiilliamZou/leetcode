/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution2 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
