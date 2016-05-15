/**
 * Created by yunxiaozou on 5/15/16.
 */

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {trees.add(null); return trees;};
        for (int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftTrees = generateTrees(start, rootValue-1);
            List<TreeNode> rightTrees = generateTrees(rootValue+1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode rootNode = new TreeNode(rootValue);
                    rootNode.left = left;
                    rootNode.right = right;
                    trees.add(rootNode);
                }
            }
        }
        return trees;
    }


}
