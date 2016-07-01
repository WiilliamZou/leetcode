/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public int closestValue(TreeNode root, double target) {
        TreeNode ceilingNode = ceiling(root, target);
        TreeNode floorNode = floor(root, target); 
        if (ceilingNode == null) 
            return floorNode.val;
        else if (floorNode == null) {
            return ceilingNode.val;
        } else if (Math.abs(ceilingNode.val-target) > Math.abs(floorNode.val-target)) {
            return floorNode.val;
        } else {
            return ceilingNode.val;
        }
        
    }

    private TreeNode floor(TreeNode root, double target) {
        if (root == null) return null;
        if (root.val > target) {
            return floor(root.left, target);
        } else {
            TreeNode node = floor(root.right, target);
            if (node != null) {
                return node;
            } else  {
                return root;
            }
        }
    }

    private TreeNode ceiling(TreeNode root, double target) {
        if (root == null) return null;
        if (root.val < target) {
            return ceiling(root.right, target);
        } else {
            TreeNode node = ceiling(root.left, target);
            if (node != null) {
                return node;
            } else {
                return root;
            }
        }
    }


}