public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        for (TreeLinkNode head = root; head != null;) {
            TreeLinkNode nextFakeHead  = new TreeLinkNode(0), nextNode = nextFakeHead;
            for (TreeLinkNode node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextNode.next = node.left;
                    nextNode = nextNode.next;
                }
                if (node.right != null) {
                    nextNode.next = node.right;
                    nextNode = nextNode.next;
                }
            }
            head = nextFakeHead.next;
        }
    }
}