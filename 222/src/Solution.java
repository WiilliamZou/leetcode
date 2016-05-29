

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode node = root.left;
        while (node != null) {
            leftHeight++;
            node = node.left;
        }
        node = root.right;
        while (node != null) {
            rightHeight++;
            node = node.right;
        }
        if (leftHeight == rightHeight) {
            return (1 << (leftHeight+1))-1 ;
        } else {
            return (1 << (rightHeight)) + countNodes(root.left);
        }
    }
}