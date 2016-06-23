import java.util.List;

/**
 * Created by yunxiaozou on 6/23/16.
 */
public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for (int i = dp.length-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == dp.length-1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
