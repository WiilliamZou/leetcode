import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/20/16.
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            }

            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder

        }
        return result;
    }
}
