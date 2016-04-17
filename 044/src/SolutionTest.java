import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/16/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void isMatch() throws Exception {
        Solution solution = new Solution();
        assertTrue(solution.isMatch("ab", "?*"));
    }

}