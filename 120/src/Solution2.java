import java.util.List;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++)
        {
            List<Integer> row = triangle.get(i);

            // iterate backwards so we don't write over our cache in the dp
            // array.  If we start from the last we will never overwrite values
            // that we will need later.
            for (int j = i; j >= 0; j--)
            {
                int val = row.get(j);

                // if we are on the first column then the only adjacent
                // number is already stored in dp[j] from the previous row
                if (j == 0)
                {
                    dp[j] += val;
                }

                // if we are on the last column then we are adding a new
                // value to the dp array since it increases by one each row.
                // Add the dp from the previous row which is located at dp[j-1]
                else if (j == i)
                {
                    dp[j] = val + dp[j - 1];
                }

                // we are in between and we need to take the min dp from the
                // adjacent cells in the previous row.
                else
                {
                    dp[j] = Math.min(dp[j], dp[j-1]) + val;
                }
            }
        }

        for (int num: dp)
        {
            min = Math.min(num, min);
        }
        return min;
    }
}
