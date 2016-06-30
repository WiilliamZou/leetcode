/**
 * Created by yunxiaozou on 6/29/16.
 */
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
           if (node.left != null) {
               TreeNode prev = node.left;
               while(prev.right != null) {
                   prev = prev.right;
               }
               prev.right = node.right;
               node.right = node.left;
               node.left = null;
           }
            node = node.right;
        }
    }
}
