public class NumMatrix {
    long[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            sum = null;
            return;
        }
        sum = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long prev1, prev2, prev3;
                prev1 = (i != 0 && j != 0) ? sum[i-1][j-1]: 0;
                prev2 = (i != 0) ? sum[i-1][j]: 0;
                prev3 = (j != 0) ? sum[i][j-1]: 0;
                sum[i][j] = prev2 + prev3 - prev1 + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) return 0 ;
        if (row1 == 0 && col1 == 0) {
            return (int)sum[row2][col2];
        } else if (row1 == 0) {
            return (int) (sum[row2][col2] - sum[row2][col1-1]);
        } else if (col1 == 0) {
            return (int) (sum[row2][col2] - sum[row1-1][col2]);
        } else {
            return (int) (sum[row2][col2] - sum[row1-1][col2]
            - sum[row2][col1-1] + sum[row1-1][col1-1]);
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);