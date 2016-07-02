public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        return searchMatrix(matrix, target, 0, M*N-1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int left, int right) {
        if (left > right) return false;
        int mid = left + (right-left)/2;
        int i = mid / matrix[0].length;
        int j = mid % matrix[0].length;
        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] > target) return searchMatrix(matrix, target, left, mid-1);
        else return searchMatrix(matrix, target, mid+1, right);
    }
}