
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder,0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = 0;
        for (index = inLeft; index < inRight; index++) {
            if (inorder[index] == preorder[preLeft])
                break;
        }

        root.left = buildTree(preorder, preLeft+1, preLeft+index-inLeft, inorder, inLeft, index-1);
        root.right = buildTree(preorder,preLeft+index-inLeft+1, preRight, inorder, index+1, inRight);
        return root;
    }
}