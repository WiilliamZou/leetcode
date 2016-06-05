/**
 * Created by yunxiaozou on 6/5/16.
 */
public class Solution02 {
    private char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int[] colBound = searchCols(y);
        int[] rowBound = searchRows(x);
        return (rowBound[1]-rowBound[0]+1) * (colBound[1]-colBound[0]+1);
    }

    private int[] searchCols(int y) {
        int col1, col2, left, right;
        col1 = col2 = y;
        left = 0;
        right = y;
        // search for col1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            while (k < image.length && image[k][mid] == '0') ++k;
            if (k < image.length) {
                col1 = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        left = y;
        right = image[0].length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            while (k < image.length && image[k][mid] == '0') ++k;
            if (k < image.length) {
                col2 = mid;
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{col1, col2};
    }

    private int[] searchRows(int x) {
        int row1, row2, left, right;
        row1 = row2 = x;
        left = 0; right = x;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            while (k < image[0].length && image[mid][k] == '0') ++k;
            if (k < image[0].length) {
                row1 = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        left = x;
        right = image.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            while (k < image[0].length && image[mid][k] == '0') ++k;
            if (k < image[0].length) {
                row2 = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return new int[]{row1, row2};
    }
}
