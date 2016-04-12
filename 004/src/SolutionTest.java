import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void TestGetkth() {
        Solution sol = new Solution();
        int[] A = {1};
        int[] B = {0};
        //assertEquals(0, sol.getkth(A, B, 1));
        assertEquals(1, sol.getkth(A, B, 2));
    }

}