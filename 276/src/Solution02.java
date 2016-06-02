/**
 * Created by yunxiaozou on 6/2/16.
 */
public class Solution02 {
    public int numWays(int n, int k) {
        if (( n== 0 || k == 0) || (k == 1 && n >= 3))
            return 0;
        int[] dp = new int[n];
        dp[0] = k;
        if (n >= 2)
            dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
        }
        return dp[n-1];
    }
}
