import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yunxiaozou on 6/1/16.
 */
public class Solution02 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        inorder(root, target, false, s1);
        inorder(root, target, true, s2);

        while (k-- > 0) {
            if (s1.isEmpty()) {
                res.add(s2.pop());
            } else if (s2.isEmpty()) {
                res.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek()))
                res.add(s1.pop());
            else
                res.add(s2.pop());
        }
        return res;
    }

    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (root == null) return;
        inorder(reverse ? root.right : root.left, target, reverse, stack);
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
    }
}
