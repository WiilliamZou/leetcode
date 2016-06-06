import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 6/6/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void verticalOrder() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(5);
        Solution sol = new Solution();
        sol.verticalOrder(root);
    }

}