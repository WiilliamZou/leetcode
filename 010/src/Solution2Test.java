import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution2Test {
    @Test
    public void isMatch() throws Exception {
        Solution sol = new Solution();
        assertTrue(sol.isMatch("aa", ".*"));
    }

    @Test
    public void isMatch2() throws Exception {
        Solution sol = new Solution();
        assertFalse(sol.isMatch("ab", ".*c"));
    }

    @Test
    public void isMatch3() throws Exception {
        Solution sol = new Solution();
        assertFalse(sol.isMatch("aaba", "ab*a*c*a"));
    }


}