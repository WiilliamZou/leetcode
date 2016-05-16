/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) return null;
        TreeNode root = new TreeNode(postorder[postRight]);
        int index = 0;
        for (index = inLeft; index <= inRight; index++)
            if (inorder[index] == postorder[postRight]) break;
        root.left = buildTree(inorder, inLeft, index-1, postorder, postLeft, postLeft+index-inLeft-1);
        root.right = buildTree(inorder, index+1, inRight, postorder, postLeft+index-inLeft, postRight-1);
        return root;
    }
}