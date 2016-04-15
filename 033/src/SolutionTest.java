import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/15/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void search() throws Exception {
        Solution sol = new Solution();
        assertEquals(0, sol.search(new int[]{1,3}, 1));
    }

    @org.junit.Test
    public void search2() throws Exception {
        Solution sol = new Solution();
        assertEquals(1, sol.search(new int[]{1,3,5}, 3));
    }

}