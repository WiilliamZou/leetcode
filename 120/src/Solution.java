import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int depth = triangle.size();
        int length = triangle.get(depth-1).size();
        int[][] dp = new int[depth][length];
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0) dp[i][j] = triangle.get(i).get(j);
                else if (j == 0 || j == triangle.get(i).size()-1) {
                    dp[i][j] = ((j == 0) ? dp[i-1][j] : dp[i-1][j-1]) + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = dp[depth-1][0];
        for (int i = 0; i < length; i++) {
            min = Math.min(min, dp[depth-1][i]);
        }
        return min;
    }
}