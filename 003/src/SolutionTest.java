import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void lengthOfLongestSubstring() throws Exception {
        Solution sol = new Solution();
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbbb"));
    }



}