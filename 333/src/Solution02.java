/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution02 {
    class Result {
        int size;
        int lower;
        int upper;
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {return 0;}
        traverse(root);
        return max;
    }

    private Result traverse(TreeNode node) {
        if (node == null) {return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);}
        Result left = traverse(node.left);
        Result right = traverse(node.right);
        if (left.size == -1 || right.size == -1 || node.val <= left.upper || node.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        return new Result(size, Math.min(left.lower, node.val), Math.max(right.upper, node.val));
    }
}
