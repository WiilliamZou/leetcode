import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> curr = new ArrayList<>();
        traverse(root, sum, result, curr);
        return result;
    }

    private void traverse(TreeNode node, int sum, List<List<Integer>> result, List<Integer> curr) {
        if (node == null) {return;}
        sum -= node.val;
        curr.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(curr));
        } else {
            if (node.left != null) {
                traverse(node.left, sum, result, curr);
            }
            if (node.right != null) {
                traverse(node.right, sum, result, curr);
            }
        }
        curr.remove(curr.size()-1);
    }
}