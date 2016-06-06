import java.util.*;
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        queue.add(root);
        col.add(0);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int i = col.remove();
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                col.add(i-1);
            }
            if (node.right != null) {
                queue.add(node.right);
                col.add(i+1);
            }
        }
        for (int key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}