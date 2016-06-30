import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void pathSum() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Solution sol = new Solution();
        System.out.println(sol.pathSum(root, 1));
    }

}