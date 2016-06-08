/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution02 {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, added = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}
