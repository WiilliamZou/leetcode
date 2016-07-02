public class Solution2 {
    private int start = -1;
    private int end = -1;
    public int[] searchRange(int[] nums, int target) {
        searchStart(nums, target, 0, nums.length-1);
        searchEnd(nums, target, 0, nums.length-1);
        return new int[]{start, end};
    }

    private void searchEnd(int[] nums, int target, int left, int right) {
        if (left > right) return;
        int mid = left + (right-left)/2;
        if (nums[mid] == target) {
            end = mid;
            searchEnd(nums, target, mid+1, right);
        } else if (nums[mid] > target) {
            searchEnd(nums, target, left, mid-1);
        } else {
            searchEnd(nums, target, mid+1, right);
        }
    }

    private void searchStart(int[] nums, int target, int left, int right) {
        if (left > right) return;
        int mid = left + (right-left)/2;
        if (nums[mid] == target) {
            start = mid;
            searchStart(nums, target, left, mid-1);
        } else if (nums[mid] > target) {
            searchStart(nums, target, left, mid-1);
        } else {
            searchStart(nums, target, mid+1, right);
        }
    }
}