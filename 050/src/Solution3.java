public class Solution3 {
    public double myPow(double x, int n) {
        long n2 = n;
        return (n >= 0) ? myPow2(x, n2) : 1 / myPow2(x, -1 * n2);
    }

    private double myPow2(double x, long n) {
        if (n == 0) {
            return 1;
        } else {
            double half = myPow2(x, n/2);
            if (n % 2 == 1) {
                return half * half * x;
            } else  {
                return  half * half;
            }
        }
    }
}