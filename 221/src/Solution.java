public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1') ? 1:0;
                } else {
                    if (matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1],
                                Math.min(dp[i][j-1], dp[i-1][j])) + 1;

                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}