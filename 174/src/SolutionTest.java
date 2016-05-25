import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void calculateMinimumHP() throws Exception {
        Solution sol = new Solution();
        int[][] du = {{0, -3}};
        sol.calculateMinimumHP(du);
    }

}