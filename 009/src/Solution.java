

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return  false;
        int re = reverse(x);
        return re == x;
    }
    private int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE)
            return 0;
        return (int) result;
    }
}