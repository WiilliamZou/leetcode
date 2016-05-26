/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution3 {
    public int rangeBitwiseAnd(int m, int n) {
        int r=Integer.MAX_VALUE;
        while((m&r)!=(n&r))  r=r<<1;
        return n&r;
    }
}