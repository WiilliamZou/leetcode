/**
 * Created by yunxiaozou on 4/15/16.
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution {
    int leftPoint = -1;
    int rightPoint = -1;
    public int[] searchRange(int[] nums, int target) {
        search(nums, target, 0, nums.length-1, true);
        search(nums, target, 0, nums.length-1, false);
        return new int[]{leftPoint, rightPoint};
    }

    public void search(int[] nums, int target, int left, int right, boolean direction) {
        if (left > right) return;
        int mid = left + (right-left)/2;
        if (nums[mid] == target) {
            if (direction) {
                leftPoint = mid;
                search(nums, target, left, mid-1, direction);
            } else {
                rightPoint = mid;
                search(nums, target, mid+1, right, direction);
            }
        } else if (nums[mid] > target) {
            search(nums, target, left, mid-1, direction);
        } else {
            search(nums, target, mid+1, right, direction);
        }
    }
}