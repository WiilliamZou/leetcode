import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    private class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            if (pair.node.left == null && pair.node.right == null)
                return pair.depth;
            if (pair.node.left != null)
                queue.add(new Pair(pair.node.left, pair.depth+1));
            if (pair.node.right != null)
                queue.add(new Pair(pair.node.right, pair.depth+1));
        }
        return 0;
    }
}