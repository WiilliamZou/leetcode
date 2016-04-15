

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/14/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void testSolution() {
        Solution sol = new Solution();
        String s = "barfoothefoobarman";
        String[] wordList = {"foo", "bar"};
        System.out.println(sol.findSubstring(s, wordList));
    }
}