import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void recoverTree() throws Exception {
        TreeNode root = new TreeNode(0);
        TreeNode node = new TreeNode(1);
        root.left = node;
        Solution sol = new Solution();
        sol.recoverTree(root);
    }

}