import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yunxiaozou on 5/15/16.
 */
public class


Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {// Travel to the left leaf
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop(); // Backtracking to higher level node A
            res.add(cur.val);  // Add the node to the result list
            cur = cur.right;   // Switch to A'right branch
        }
        return res;
    }
}
