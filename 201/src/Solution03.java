/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution03 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >>> 1;
            n = n >>> 1;
            count = count+1;
        }
        return n << count;
    }
}
