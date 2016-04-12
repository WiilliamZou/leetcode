import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void testLength() {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abcb"));
        System.out.println(sol.longestPalindrome("abba"));
    }
}