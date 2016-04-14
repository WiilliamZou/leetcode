import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/13/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void divide() throws Exception {
        Solution sol = new Solution();
        assertEquals(2147483647, sol.divide(-2147483648, -1));
    }

}