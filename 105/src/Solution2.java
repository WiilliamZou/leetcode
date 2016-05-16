/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int idx, int[] inorder, int end, int start) {
        if (idx >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        int i;
        for (i = end; i >= start; i--) {
            if (preorder[idx] == inorder[i]) {
                break;
            }
        }
        root.left = buildTree(preorder, idx + 1, inorder, i - 1, start);
        root.right = buildTree(preorder, idx + i - start + 1, inorder, end, i+1);
        return root;
    }
}
