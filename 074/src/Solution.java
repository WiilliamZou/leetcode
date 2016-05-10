public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        return searchMatrix(matrix, target, 0, M*N-1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int left, int right) {
        if (left > right) return false;
        int mid = (left+right)/2;
        int r = mid / matrix[0].length;
        int c = mid % matrix[0].length;
        if (matrix[r][c] == target) return true;
        else if (matrix[r][c] < target) return searchMatrix(matrix, target, mid+1, right);
        else return searchMatrix(matrix, target, left, mid-1);
    }
}