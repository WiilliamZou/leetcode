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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if (!map.containsKey(node.i)) {
                map.put(node.i, new ArrayList<>());
            }
            map.get(node.i).add(node.treeNode.val);
            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, node.i-1));
            }
            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, node.i+1));
            }
        }
        for (int key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    private class Node {
        TreeNode treeNode;
        int i;
        public Node(TreeNode treeNode, int i) {
            this.treeNode = treeNode;
            this.i = i;
        }
    }


}