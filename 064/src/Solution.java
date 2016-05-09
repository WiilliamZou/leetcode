public class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            dp[i][0] = (i > 0) ? dp[i-1][0] + grid[i][0] : grid[i][0];
        }
        for (int i = 0; i < N; i++) {
            dp[0][i] = (i > 0) ? dp[0][i-1] + grid[0][i] : grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[M-1][N-1];
    }
}