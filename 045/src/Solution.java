/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int pointer = 0;
        while (pointer < nums.length) {
            if (dp[pointer] != 0) {
                int j = nums[pointer] + pointer;
                for (int i = pointer+1; i < nums.length && i <= j; i++) {
                    if (dp[i] == 0 || (nums[pointer] + 1 < dp[i])) {
                        dp[i] = nums[pointer] + 1;
                    }
                }
            }
            pointer++;
        }
        return dp[nums.length-1];
    }
}