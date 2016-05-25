/**
 * Created by yunxiaozou on 5/25/16.
 */
public class Solution02 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
