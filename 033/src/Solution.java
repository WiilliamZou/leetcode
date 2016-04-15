/**
 * Created by yunxiaozou on 4/15/16.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        if (left == right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[left] < nums[mid]) {
            if (target > nums[left] && target < nums[mid]) {
                return search(nums, target, left, mid-1);
            }else {
                return search(nums, target, mid+1, right);
            }
        } else {
            if(target > nums[mid] && target < nums[right]) {
                return search(nums, target, mid+1, right);
            } else {
                return search(nums, target, left, mid-1);
            }
        }
    }
}