public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 ) return 1;
        if (x == 0) return 0;
        int signN = (n > 0)? 1 : -1;
        long tempN = Math.abs(n);
        double result = 1;
        if (tempN % 2 == 1) {
            result = x;
            tempN--;
        }
        double tempResult = myPow(x, (int)(tempN/2));
        result *= tempResult * tempResult;
        if (signN < 0)
            result = 1 / result;
        return result;
    }
}