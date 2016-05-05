public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        } else if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        } else if (n == 0 ) {
            return 1;
        } else if (n < 0){
            return 1 / myPow(x, -n);
        } else if (n % 2 == 0) {
            double result = myPow(x, n/2);
            return result * result;
        } else {
            return x * myPow(x, n-1);
        }

    }
}