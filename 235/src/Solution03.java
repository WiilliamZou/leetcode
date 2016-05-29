/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution03 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else {
                return root;
            }
        }
    }
}
