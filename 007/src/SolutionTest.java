import org.testng.annotations.Test;

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void reverse() throws Exception {
        Solution sol = new Solution();
        assertEquals(321, sol.reverse(123));
        assertEquals(-123, sol.reverse(-321));
    }

}