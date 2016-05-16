/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
        for (TreeLinkNode head = root; head != null; ) {
            TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
            for (TreeLinkNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextTail.next = node.left;
                    nextTail = node.left;
                }
                if (node.right != null) {
                    nextTail.next = node.right;
                    nextTail = node.right;
                }
            }
            head = nextHead.next;
        }
    }
}
