public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] dp = new int[M][N];
        dp[M-1][N-1] = (dungeon[M-1][N-1] >= 0) ? 1 : 1 - dungeon[M-1][N-1];
        for (int i = M-2; i >= 0; i--) {
            dp[i][N-1] = Math.max(1, dp[i+1][N-1] - dungeon[i][N-1]);
    }
        for (int j = N-2; j >= 0; j--) {
            dp[M-1][j] = Math.max(1, dp[M-1][j+1] - dungeon[M-1][j]);
        }

        for (int i = M-2; i >= 0; i--) {
            for (int j = N-2; j >= 0; j--) {
                int first = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                int second = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                dp[i][j] = Math.min(first, second);
            }
        }
        return dp[0][0];
    }
}