/**
 * Created by yunxiaozou on 5/23/16.
 */
public class Solution03 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode temp = null;

        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
