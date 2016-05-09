/**
 * Created by yunxiaozou on 12/20/15.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        double answer = 1;

        for (int i = 1; i <= n - 1; i++) {
            double divend  = m + i - 1;
            double divor = i ;
            answer *= divend / divor;
        }

        int answer1 = (int) answer;
        int answer2 = answer1 + 1;
        if (Math.abs(answer1 - answer) > Math.abs(answer2 - answer)) {
            return answer2;
        } else {
            return answer1;
        }


    }
}