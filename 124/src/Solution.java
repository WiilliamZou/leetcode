/**
 * Created by yunxiaozou on 5/18/16.
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return max;
    }

    private int traverse(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = Math.max(traverse(node.left), 0);
        int right = Math.max(traverse(node.right), 0);
        max = Math.max(max, node.val+left+right);
        return node.val + Math.max(left, right);
    }
}