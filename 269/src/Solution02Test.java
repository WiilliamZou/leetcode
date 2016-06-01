import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 6/1/16.
 */
public class Solution02Test {
    @org.junit.Test
    public void alienOrder() throws Exception {
        String[] input = new String[5];
        input[0] = "wrt";
        input[1] = "wrf";
        input[2] = "er";
        input[3] = "ett";
        input[4] = "rftt";
        Solution02 sol = new Solution02();
        System.out.println(sol.alienOrder(input));
    }

}