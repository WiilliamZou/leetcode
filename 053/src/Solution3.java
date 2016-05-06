/**
 * Created by yunxiaozou on 5/6/16.
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayRec(nums, 0, nums.length-1);
    }

    private int maxSubArrayRec(int[] nums, int left, int right) {
        return 0;
    }
}
