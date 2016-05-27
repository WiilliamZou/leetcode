/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution02 {
    private int rob(int[] num, int lo, int hi) {
        int[] dp = new int[hi-lo+1];
        for (int i = lo; i <= hi; i++) {
            if (i == lo) {
                dp[i-lo] = num[i];
            } else if (i == lo+1) {
                dp[i-lo] = Math.max(num[i], dp[i-lo-1]);
            } else {
                dp[i-lo] = Math.max(num[i] + dp[i-lo-2], dp[i-lo-1]);
            }
        }
        return dp[hi];
    }
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
