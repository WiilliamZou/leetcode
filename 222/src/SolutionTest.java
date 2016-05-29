import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/28/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void countNodes() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution sol = new Solution();
        System.out.println(sol.countNodes(root));

    }

}