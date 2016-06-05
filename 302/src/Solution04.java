/**
 * Created by yunxiaozou on 6/5/16.
 */
public class Solution04 {
    private char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int col1, col2, row1, row2;
        col1 = searchRange(y, true, true);
        col2 = searchRange(y, true, false);
        row1 = searchRange(x, false, true);
        row2 = searchRange(x, false, false);
        return (row2-row1+1) * (col2-col1+1);

    }

    private int searchRange(int x, boolean forColumn, boolean forLeft) {
        int point, left, right;
        point = x;
        if (forLeft){
            left = 0;
            right = x;
        } else {
            left = x;
            right = (forColumn) ? image[0].length-1: image.length-1;
        }
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            int bound = (forColumn) ? image.length: image[0].length;
            int value = (forColumn) ? image[k][mid]: image[mid][k];
            while (k < bound && value == '0') {
                k++;
                if (k < bound) {
                    value = (forColumn) ? image[k][mid]: image[mid][k];
                }
            }
            if (k < bound) {
                point = mid;
                if (forLeft) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (forLeft) {
                    left = mid+1;
                } else  {
                    right = mid-1;
                }
            }
        }
        return point;
    }
}
