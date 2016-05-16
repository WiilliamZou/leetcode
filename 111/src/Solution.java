/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int height) {
        if (node == null) return height;
        if (node.left == null) return traverse(node.right, height+1);
        else if (node.right == null) return traverse(node.left, height+1);
        else return Math.min(traverse(node.left,height+1), traverse(node.right, height+1));
    }

}
