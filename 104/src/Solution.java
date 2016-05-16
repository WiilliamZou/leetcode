public class Solution {
    int maxLevel = 0;
    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return maxLevel;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) return;
        maxLevel = Math.max(level, maxLevel);
        traverse(node.left, level+1);
        traverse(node.right, level+1);

    }
}