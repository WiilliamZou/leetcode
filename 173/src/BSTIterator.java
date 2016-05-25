import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = null;
    public BSTIterator(TreeNode root) {
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (node != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode temp = stack.pop();
        node = temp.right;
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */