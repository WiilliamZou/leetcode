import java.util.ArrayList;

/**
 * Created by yunxiaozou on 4/12/16.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 UPDATE (2016/2/13):
 The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (array.contains(target - nums[i])) {
                return new int[] {array.indexOf(target-nums[i]), i};
            } else {
                array.add(nums[i]);
            }
        }
        return null;
    }
}