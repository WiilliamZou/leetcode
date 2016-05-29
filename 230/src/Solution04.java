import java.util.Stack;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution04 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (k != 0) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            k--;
            if (k == 0) return node.val;
            node = node.right;
        }
        return -1;
    }
}
