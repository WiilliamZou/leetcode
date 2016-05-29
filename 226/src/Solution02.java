import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution02 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return root;
    }
}
