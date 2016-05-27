/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution03 {
    public int minSubArrayLen(int sum, int[] nums) {
        int i = 0, j = 0, curSum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            while (curSum < sum && j < nums.length) sum += nums[j++];
            if (curSum >= sum) {
                while (curSum >= sum && i < j) sum -= nums[i++];
                min = Math.min(min, j-i+1);
            }

        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}
