import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/20/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void canCompleteCircuit() throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.canCompleteCircuit(new int[]{1,2}, new int[]{2,1}));
    }

}