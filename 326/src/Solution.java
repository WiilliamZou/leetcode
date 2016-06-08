/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        int max3PowerInt = 1162261467;
        if (n <= 0 || n > max3PowerInt) return false;
        return max3PowerInt % n == 0;
    }
}
