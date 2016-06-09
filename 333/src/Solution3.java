/*
    in brute-force solution, we get information in a top-down manner.
    for O(n) solution, we do it in bottom-up manner, meaning we collect information during backtracking.
*/
public class Solution3 {

    class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
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
        if (root == null) { return 0; }
        traverse(root, null);
        return max;
    }

    private Result traverse(TreeNode root, TreeNode parent) {
        if (root == null) { return new Result(0, parent.val, parent.val); }
        Result left = traverse(root.left, root);
        Result right = traverse(root.right, root);
        if (left.size==-1 || right.size==-1 || root.val<left.upper || root.val>right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, left.lower, right.upper);
    }
}