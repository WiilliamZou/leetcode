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
    public boolean isValidBST(TreeNode root) {
        return validateRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateRange(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (!(root.val > min && root.val < max)) return false;
        return validateRange(root.left, min, (long) root.val)
                && validateRange(root.right, (long) root.val, max);
    }
}