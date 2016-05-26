/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution02 {
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 0) return 0;
        int[] dp = new int[l];
        for (int i = 0; i < l; i++) {
            if (i == 0)
                dp[i] = nums[i];
            else if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i-1]);
            }else {
                dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            }
        }
        return dp[l-1];
    }
}
