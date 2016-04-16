/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null && nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
        int k = 1;
        while (k <= nums.length && nums[k-1] == k) {
            k++;
        }
        return k;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}