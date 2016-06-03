/**
 * Created by yunxiaozou on 6/3/16.
 */
public class Solution2 {
    // notice that the tree is binary search tree.
    // 相当于是ceiling function
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return succ;
    }
}
