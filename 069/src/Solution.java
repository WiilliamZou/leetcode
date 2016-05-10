/**
 * Created by yunxiaozou on 5/10/16.
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 0) return 0;
        if (x == 0 || x == 1) return x;
        return mySqrt(x, 1, x);
    }

    private int mySqrt(long x, long left, long right) {
        long mid = (left + right) / 2;
        if (mid * mid <= x && (mid+1) * (mid+1) > x) return (int) mid;
        else if (mid * mid < x) return mySqrt(x, mid+1, right);
        else return mySqrt(x, left, mid-1);

    }
}
