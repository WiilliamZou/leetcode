import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> floorStack = floors(root, target, new Stack<TreeNode>());
        Stack<TreeNode> ceilingStack = ceilings(root, target, new Stack<TreeNode>());
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (count < k && (!floorStack.isEmpty() || !ceilingStack.empty())) {
            if (floorStack.isEmpty()) {
                result.add(ceilingStack.pop().val);
            } else if (ceilingStack.isEmpty()) {
                result.add(floorStack.pop().val);
            } else {
                TreeNode leftNode = floorStack.peek();
                TreeNode rightNode = ceilingStack.peek();
                if (Math.abs(leftNode.val-target) > Math.abs(rightNode.val-target)) {
                    result.add(rightNode.val);
                    ceilingStack.pop();
                }else {
                    result.add(leftNode.val);
                    floorStack.pop();
                }
            }
            count++;
        }
        return result;
    }

    private Stack<TreeNode> ceilings(TreeNode root, double target, Stack<TreeNode> stack) {
        if (root == null) {
            return stack;
        }
        ceilings(root.right, target, stack);
        if (root.val > target) {
            stack.push(root);
            ceilings(root.left, target,stack);
        }
        return stack;
    }

    private Stack<TreeNode> floors(TreeNode root, double target, Stack<TreeNode> stack) {
        if (root == null) {
            return stack;
        }
        floors(root.left, target, stack);
        if (root.val <= target) {
            stack.push(root);
            floors(root.right, target, stack);
        }
        return stack;
    }
}