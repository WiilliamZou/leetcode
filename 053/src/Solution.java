/**
 * Created by yunxiaozou on 5/5/16.
 *
 * 53. Maximum Subarray   My Submissions QuestionEditorial Solution
 Total Accepted: 110541 Total Submissions: 301452 Difficulty: Medium
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null && nums.length == 0)
            return 0;
        int localMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            globalMax = Math.max(localMax, globalMax);

        }
        return globalMax;

    }
}