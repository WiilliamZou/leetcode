/**
 * Created by yunxiaozou on 4/15/16.
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        if(left > right)
            return left;
        int mid = (left + right)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchInsert(nums, target, left, mid-1);
        } else {
            return searchInsert(nums, target, mid+1, right);
        }
    }

}
