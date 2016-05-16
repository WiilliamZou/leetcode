import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        boolean isRightDirection = false;
        while (!q1.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.remove();
                if (node == null) continue;
                curr.add(node.val);
                q1.add(node.left);
                q1.add(node.right);
            }

            if (!curr.isEmpty()) {
                if (isRightDirection) Collections.reverse(curr);
                result.add(curr);
            }
            isRightDirection = !isRightDirection;

        }
        return result;
    }
}