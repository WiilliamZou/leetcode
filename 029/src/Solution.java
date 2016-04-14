/**
 * Created by yunxiaozou on 4/13/16.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = (dividend < 0) ^ (divisor < 0);
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long sum = 0;
        long count = 0;
        if (divisorLong == 1) {
            count = dividendLong;
        } else {
            while (sum < dividendLong) {
                if (sum != 0 && sum + sum < dividendLong) {
                    count = count + count;
                    sum = sum + sum;
                } else {
                    //int part
                }
            }
        }

        if (positive == false) {
            count = count * -1;
        }
        if (count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)count;

    }
}