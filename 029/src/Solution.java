/**
 * Created by yunxiaozou on 4/13/16.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long sum = 0;
        long result = 0;
        while (divisorLong <= dividendLong){
            long count = 0;
            while (dividendLong >= divisorLong << count) {
                count++;
            }
            count--;
            result += 1L << count;
            dividendLong -= divisorLong << count;
        }
        if (negative)
            result = 0 - result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)result;

    }
}