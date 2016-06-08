/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution02 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0, m = matrix.length, n = matrix[0].length;

        int[][] cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache), max);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (matrix[i][j] <= min)
            return 0;

        if (cache[i][j] != 0)
            return cache[i][j];
        min = matrix[i][j];
        int a = dfs(matrix, min, i-1, j, m, n, cache) + 1;
        int b = dfs(matrix, min, i+1, j, m, n, cache) + 1;
        int c = dfs(matrix, min, i, j-1, m, n, cache) + 1;
        int d = dfs(matrix, min, i, j+1, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
}
