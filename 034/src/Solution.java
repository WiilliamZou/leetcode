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
        searchLeft(nums, target, 0, nums.length-1);
        searchRight(nums, target, 0, nums.length-1);
        return new int[]{leftPoint, rightPoint};
    }
    public void searchLeft(int[] nums, int target, int left, int right) {
        if (left > right) return;
        int mid = (left + right) /2;
        if (nums[mid]== target) {
            leftPoint = mid;
            searchLeft(nums, target, left, mid-1);
        } else if (nums[mid] > target) {
            searchLeft(nums, target, left, mid-1);
        } else {
            searchLeft(nums, target, mid+1, right);
        }
    }
    public void searchRight(int[] nums, int target, int left, int right) {
        if (left > right) return;
        int mid = (left + right) /2;
        if (nums[mid] == target) {
            rightPoint = mid;
            searchRight(nums, target, mid+1, right);
        } else if (nums[mid] > target) {
            searchRight(nums, target, left, mid-1);
        } else {
            searchRight(nums, target, mid+1, right);
        }
    }
}