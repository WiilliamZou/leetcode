import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution02 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> I = new ArrayList<>(m);
        List<Integer> J = new ArrayList<>(n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                    J.add(j);
                }
            }
        }

        return getMin(I) + getMin(J);
    }

    private int getMin(List<Integer> list) {
        int ret = 0;
        Collections.sort(list);
        int i = 0;
        int j = list.size()-1;
        while (i < j) {
            ret += list.get(j--) - list.get(i++);
        }
        return ret;
    }
}
