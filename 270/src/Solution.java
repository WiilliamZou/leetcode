

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
    public int closestValue(TreeNode root, double target) {
        if (root.val > target) {
            if (root.left != null) {
                int leftVal = closestValue(root.left, target);
                if (Math.abs(leftVal-target) > Math.abs(root.val-target)) {
                    return root.val;
                } else {
                    return leftVal;
                }
            } else {
                return root.val;
            }
        } else {
            if (root.right != null) {
                int rightVal = closestValue(root.right, target);
                if (Math.abs(rightVal-target) > Math.abs(root.val-target)) {
                    return root.val;
                } else {
                    return rightVal;
                }
            } else {
                return root.val;
            }
        }
    }
}