public class Solution2 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        int nSign = n < 0 ? -1 : 1;
        n = Math.abs(n); //take care when the n is MIN.value

        double result = myPow(x, n / 2);
        result *= result;
        if (n % 2 != 0) {
            result *= x;
        }

        return nSign < 0 ? 1 / result : result;
    }
}