/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public int reverse(int x) {
        boolean positive = (x >= 0) ? true : false;
        long a = Math.abs(x);
        long b = 0;
        while (a != 0) {
            b = 10 * b + a % 10;
            a /= 10;
        }
        b = (positive)? b : (-1) * b;
        if (b > Integer.MAX_VALUE)
            return 0;
        else if (b < Integer.MIN_VALUE)
            return 0;
        else
            return (int)b;

    }
}