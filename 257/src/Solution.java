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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (root == null) return result;
        dfs(root, current, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> current, List<String> result) {
        if (node == null) {
            output(current, result);
        } else {
            current.add(node.val);
            if (node.left == null) {
                dfs(node.right, current, result);
            } else if (node.right == null) {
                dfs(node.left, current, result);
            } else {
                dfs(node.left, current, result);
                dfs(node.right, current, result);
            }
            current.remove(current.size()-1);
        }
    }

    private void output(List<Integer> current, List<String> result) {
        if (current.size() == 0) return;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            if (i == 0) builder.append(current.get(i));
            else {
                builder.append("->");
                builder.append(current.get(i));
            }
        }
        result.add(builder.toString());
    }
}