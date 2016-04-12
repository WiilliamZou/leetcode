import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void testTwoSum1()   {
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(new int[]{0,1}, sol.twoSum(nums, target));
    }
    @Test
    public void testTwoSum2()   {
        Solution2 sol = new Solution2();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(new int[]{0,1}, sol.twoSum(nums, target));
    }

}