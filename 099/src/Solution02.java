import java.util.Stack;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution02 {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.val >= node.val) {
                if (first == null) first = prev;
                second = node;
            }
            prev = node;
            node = node.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
