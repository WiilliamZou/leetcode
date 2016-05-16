/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode node){
        // return the last node after recursion
        TreeNode last = node;
        TreeNode right = node.right;
        if (node.left != null){
            node.right = node.left;
            last = flattenTree(node.left);
            node.left = null; // don't forget this
        }
        if (node.right != null){
            last.right = right;
            last = flattenTree(node.right);
        }
        return last;
    }
}
