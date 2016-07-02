public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        if (left > right) return left;
        int mid = left + (right-left)/2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return searchInsert(nums, target, left, mid-1);
        else return searchInsert(nums, target, mid+1, right);
    }
}