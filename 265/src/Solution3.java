/**
 * Created by yunxiaozou on 5/31/16.
 */
public class Solution3 {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)  return 0;
        int k = costs[0].length;
        int[] dp = new int[k];
        int m1 = 0, m2 = 0;
        for(int i = costs.length - 1; i >= 0; i--){
            int[] tempdp = new int[k];
            int mm1 = m1, mm2 = m2;
            m1 = Integer.MAX_VALUE; m2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                tempdp[j] = (dp[j] == mm1 ? mm2 : mm1) + costs[i][j];
                if(tempdp[j] < m1){
                    m2 = m1;
                    m1 = tempdp[j];
                }
                else
                    m2 = Math.min(m2, tempdp[j]);
            }
            dp = tempdp;
        }
        return m1;
    }
}
