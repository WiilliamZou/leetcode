import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void myAtoi() throws Exception {
        Solution sol = new Solution();
        assertEquals(1, sol.myAtoi("1"));
        assertEquals(-12, sol.myAtoi("  -0012a42"));
        assertEquals(2147483647, sol.myAtoi("2147483648"));
        assertEquals(2147483647, sol.myAtoi("9223372036854775809"));
    }
    @org.junit.Test
    public void myAtoi2() throws Exception {
        Solution sol = new Solution();
        assertEquals(-12, sol.myAtoi("  -0012a42"));
    }
    @org.junit.Test
    public void myAtoi3() throws Exception {
        Solution sol = new Solution();
        assertEquals(2147483647, sol.myAtoi("9223372036854775809"));
    }
    @org.junit.Test
    public void myAtoi4() throws Exception {
        Solution sol = new Solution();
        assertEquals(2147483647, sol.myAtoi("18446744073709551617"));
    }

}