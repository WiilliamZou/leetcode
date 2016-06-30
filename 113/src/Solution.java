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
        dfsTraverse(root, sum, result, curr);
        return result;
    }

    private void dfsTraverse(TreeNode node, int sum, List<List<Integer>> result, List<Integer> curr) {
        if (node == null && sum == 0) {result.add(new ArrayList<>(curr)); return;}
        if (node == null) {return;}
        if (node.left == null) {
            curr.add(node.val);
            dfsTraverse(node.right, sum-node.val, result, curr);
            curr.remove(curr.size()-1);
        } else if (node.right == null) {
            curr.add(node.val);
            dfsTraverse(node.left, sum-node.val, result, curr);
            curr.remove(curr.size()-1);
        } else {
            curr.add(node.val);
            dfsTraverse(node.left, sum-node.val, result, curr);
            dfsTraverse(node.right, sum-node.val, result, curr);
            curr.remove(curr.size()-1);
        }
    }
}