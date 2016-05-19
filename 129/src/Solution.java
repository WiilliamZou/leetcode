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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 0);
        return sum;
    }

    private void traverse(TreeNode node, int curr) {
        if (node == null) sum += curr;
        else if (node.left == null) traverse(node.right, curr*10+node.val);
        else if (node.right == null) traverse(node.left, curr*10+node.val);
        else {
            traverse(node.left, node.val+curr*10);
            traverse(node.right, node.val+curr*10);
        }
    }
}