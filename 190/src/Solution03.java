/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution03 {
    public int reverseBits(int n) {
        int[] tb = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result = result << 4 | tb[n & 0xF];
            n >>>= 4;
        }
        return result;
    }
}
