public class Solution {
    public void rotate(int[][] matrix) {
        for (int min = 0, max = matrix.length-1; min < max; min++, max--) {
            for (int i = 0; i < max-min; i++) {
                int temp = matrix[min][min+i];
                matrix[min][min+i] = matrix[max-i][min];
                matrix[max-i][min] = matrix[max][max-i];
                matrix[max][max-i] = matrix[min+i][max];
                matrix[min+i][max] = temp;
            }
        }
    }
}