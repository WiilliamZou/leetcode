/**
 * Created by yunxiaozou on 5/30/16.
 */
public class Solution02 {
    public int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        traverse(root);
        return count;
    }

    private boolean traverse(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = traverse(node.left);
        boolean right = traverse(node.right);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
