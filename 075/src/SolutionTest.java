import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 5/10/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void searchMatrix() throws Exception {
        Solution sol = new Solution();
        int[][] matrix = {{1,1}};
        System.out.println(sol.searchMatrix(matrix, 2));

    }

}