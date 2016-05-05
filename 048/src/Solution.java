/**
 * Created by yunxiaozou on 5/4/16.
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Solution {
    public void rotate(int[][] matrix) {
        for (int level = 0; level < matrix.length/2; level++) {
            for (int row = level; row < matrix.length - 1 - level; row++){
                int temp = matrix[row][level];
                matrix[row][level] = matrix[matrix.length-1-row][level];
                matrix[matrix.length-1-row][level] = matrix[matrix.length-1-level][matrix.length-1-row];
                matrix[matrix.length-1-level][matrix.length-1-row] = matrix[row][matrix.length-1-level];
                matrix[row][matrix.length-1-level] = temp;
            }
        }
    }
}