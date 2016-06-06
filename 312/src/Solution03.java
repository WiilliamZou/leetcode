/**
 * Created by yunxiaozou on 6/6/16.
 */
public class Solution03 {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length+2];
        int n = 1;
        for (int x: iNums) {
            if (x > 0)
                nums[n++] = x;
        }
        nums[0] = nums[n++] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            //k means left, right 之间的长度。
            //[left, right] 之间至少有一个元素。
            for (int left = 0; left < n-k; ++left) {
                int right = left + k;
                for (int i = left+1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left]*nums[i]*nums[right]+
                            dp[left][i] +
                            dp[i][right]);
                    // dp 的增量还是通过 nums[left]*nums[i]*nums[right] 得到
                    // 如何确定 left, i, right, 通过取最大值得到。
                }
            }
        }
        return dp[0][n-1];
    }
}
