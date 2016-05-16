/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution02 {
    public boolean isBalanced(TreeNode root) {
        return traverse(root, 0) >= 0;
    }

    private int traverse(TreeNode node, int height) {
        if (node == null) return height;
        int left = traverse(node.left, height+1);
        int right = traverse(node.right, height+1);
        if (left >= 0 && right >= 0 && Math.abs(left-right) <= 1)
            return Math.max(left, right);
        else
            return -1;
    }
}

