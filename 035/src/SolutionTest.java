import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 6/24/16.
 */
public class SolutionTest {
    @Test
    public void searchInsert1() throws Exception {
        Solution sol = new Solution();
        sol.searchInsert(new int[]{1,3,5,6} , 2);
    }
    @Test
    public void searchInsert2() throws Exception {
        Solution sol = new Solution();
        sol.searchInsert(new int[]{1,3,5,6} , 7);
    }
    @Test
    public void searchInsert3() throws Exception {
        Solution sol = new Solution();
        sol.searchInsert(new int[]{1,3,5,6} , 0);
    }

}