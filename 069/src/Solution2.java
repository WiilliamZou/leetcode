public class Solution2 {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        return mySqrt(x, 0, x);
    }

    private int mySqrt(long x, long left, long right) {
        if (left > right) return -1;
        long mid = left + (right-left)/2;
        long product1 = mid * mid;
        long product2 = (mid+1) * (mid+1);
        if (x >= product1 && x < product2) {
            return (int)mid;
        } else if (x < product1) {
            return mySqrt(x, left, mid-1);
        } else {
            return mySqrt(x, mid+1, right);
        }
    }
}