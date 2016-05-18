/**
 * Created by yunxiaozou on 5/18/16.
 */
public class Solution2 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    public int traverse(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;
        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
