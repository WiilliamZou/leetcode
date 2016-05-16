import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void hasPathSum() throws Exception {
        TreeNode root = new TreeNode(1);
        Solution sol = new Solution();
        System.out.println(sol.hasPathSum(root, 1));
    }

}