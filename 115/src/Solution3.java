import java.util.Stack;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution3 {
    public void flatten(TreeNode root) {
        // write your code here
        // 这个算法貌似和preorder traversal 有点相似
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {return;}
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = null;
            if (right != null) {stack.push(right);}
            if (left != null) {stack.push(left);}
            if (left != null) {
                node.right = left;
            } else {
                node.right = stack.isEmpty()? right: stack.peek();
            }
        }
    }
}


