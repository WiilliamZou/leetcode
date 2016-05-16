/**
 * Created by yunxiaozou on 5/15/16.
 */
public class Solution2 {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inOrder(TreeNode curr){
        if(curr == null) return;
        inOrder(curr.left);

        //in inorder traversal of BST, prev should always have smaller value than current value
        if(prev != null && prev.val >= curr.val){
            //incorrect smaller node is always found as prev node
            if(first == null) first = prev;
            //incorrect larger node is always found as curr(curr) node
            second = curr;
        }
        //update prev node
        prev = curr;

        //search right tree
        inOrder(curr.right);
    }
}
