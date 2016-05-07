public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 1) return new int[0][0];
        int[][] result = new int[n][n];
        int count = 1;
        for (int min = 0, max = n-1; min <= max; min++, max--) {
            if (min == max) {
                result[min][min] = count++;
            } else {
                for(int i = min; i <= max; i++)
                    result[min][i] = count++;
                for (int i = min+1; i <= max; i++)
                    result[i][max] = count++;
                for (int i = max-1; i >= min; i--)
                    result[max][i] = count++;
                for (int i = max-1; i > min; i--) {
                    result[i][min] = count++;
                }
            }
        }
        return result;
    }
}