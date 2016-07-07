/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
        for (TreeLinkNode head = root; head != null; ) {
            TreeLinkNode nextDummy = new TreeLinkNode(0), nextNode = nextDummy;
            for (TreeLinkNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextNode.next = node.left;
                    nextNode = node.left;
                }
                if (node.right != null) {
                    nextNode.next = node.right;
                    nextNode = node.right;
                }
            }

        }
    }
}
