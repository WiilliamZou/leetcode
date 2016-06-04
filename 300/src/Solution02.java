import java.util.Arrays;

/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution02 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            int i  = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i+1);
            dp[i] = x;
            if (i == len) len++;
        }
        return len;
    }
}
