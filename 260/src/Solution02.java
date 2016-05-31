/**
 * Created by yunxiaozou on 5/31/16.
 */
public class Solution02 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num: nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] rets = {0, 0};
        for (int num: nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
