import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 7/1/16.
 */
public class Solution02Test {
    @org.junit.Test
    public void lengthOfLIS() throws Exception {
        Solution02 sol = new Solution02();
        sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 19});
    }
    @org.junit.Test
    public void lengthOfLIS2() throws Exception {
        Solution02 sol = new Solution02();
        sol.lengthOfLIS(new int[] {2, 5, 3, 7, 11, 1, 12});
    }
}