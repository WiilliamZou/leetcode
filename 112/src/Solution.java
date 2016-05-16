/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return traverse(root, sum);

    }

    private boolean traverse(TreeNode node, int sum) {
        if (node == null && sum == 0) return true;
        if (node == null) return false;

        if (node.left == null) return traverse(node.right, sum-node.val);
        else if (node.right == null) return traverse(node.left, sum-node.val);
        else return traverse(node.left, sum-node.val) || traverse(node.right, sum-node.val);
    }
}