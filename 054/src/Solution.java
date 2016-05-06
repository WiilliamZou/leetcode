import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/6/16.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;
        int M = matrix.length;
        int N = matrix[0].length;
        for (int rmin = 0, rmax = M-1, cmin = 0, cmax = N-1; rmin <= rmax && cmin <= cmax;
             rmin++, rmax--, cmin++, cmax--) {
            if (rmin == rmax) {
                for (int i = cmin; i <= cmax; i++)
                    result.add(matrix[rmin][i]);
            } else if (cmin == cmax) {
                for (int i = rmin; i <= rmax; i++)
                    result.add(matrix[i][cmin]);
            } else {
                for (int i = cmin; i <= cmax; i++)
                    result.add(matrix[rmin][i]);
                for (int i = rmin+1; i <= rmax; i++)
                    result.add(matrix[i][cmax]);
                for (int i = cmax-1; i >= cmin; i--)
                    result.add(matrix[rmax][i]);
                for (int i = rmax-1; i > rmin; i--)
                    result.add(matrix[i][cmin]);
            }

        }
        return result;
    }
}