import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode current1 = q1.remove(), current2 = q2.remove();
            if (current1 == null && current2 == null) continue;
            if (current1 == null || current2 == null) return false;
            if (current1.val != current2.val) return false;
            q1.add(current1.left);
            q1.add(current1.right);
            q2.add(current2.right);
            q2.add(current2.left);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}