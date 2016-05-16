import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.size() != q2.size()) return false;
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode left = q1.remove();
                TreeNode right = q2.remove();
                if (left == null && right == null) continue;
                if (left == null || right == null) return false;
                if (left.val != right.val) return false;
                q1.add(left.left);
                q1.add(left.right);
                q2.add(right.right);
                q2.add(right.left);
            }
        }
        return true;
    }
}
