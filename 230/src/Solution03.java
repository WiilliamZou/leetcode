/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution03 {
    private int number = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return number;
    }

    public void traverse(TreeNode n) {
        if (n.left != null) traverse(n.left);
        count--;
        if(count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) traverse(n.right);
    }
}
