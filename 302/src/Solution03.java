/**
 * Created by yunxiaozou on 6/5/16.
 */
public class Solution03 {
    private char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int[] colBound = searchRange(y, true);
        int[] rowBound = searchRange(x, false);
        return (rowBound[1]-rowBound[0]+1) * (colBound[1]-colBound[0]+1);
    }

    private int[] searchRange(int index, boolean forColumn) {
        int range1, range2, left, right;
        range1 = range2 = index;
        left = 0;
        right = index;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            int bound = (forColumn) ? image.length : image[0].length;
            int value = (forColumn) ? image[k][mid] : image[mid][k];
            while (k < bound && value == '0') {
                k++;
                if (k < bound) {
                    value = (forColumn) ? image[k][mid] : image[mid][k];
                }
            }
            if (k < bound) {
                range1 = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        left = index;
        right = (forColumn) ? image[0].length-1 : image.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int k = 0;
            int bound = (forColumn) ? image.length : image[0].length;
            int value = (forColumn) ? image[k][mid] : image[mid][k];
            while (k < bound && value == '0') {
                k++;
                if (k < bound) {
                    value = (forColumn) ? image[k][mid] : image[mid][k];
                }
            }
            if (k < bound) {
                range2 = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return new int[]{range1, range2};
    }
}
