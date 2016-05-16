/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode root){
        // return the last node after recursion
        TreeNode last = root;
        TreeNode right = root.right;
        if (root.left != null){
            root.right = root.left;
            last = flattenTree(root.left);
            root.left = null; // don't forget this
        }
        if (root.right != null){
            last.right = right;
            last = flattenTree(root.right);
        }
        return last;
    }
}
