import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 5/10/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void mySqrt() throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.mySqrt(2147395599));
    }
    @org.junit.Test
    public void mySqrt2() throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.mySqrt(2147483647));
    }

}