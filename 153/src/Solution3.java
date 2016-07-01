public class Solution3 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (nums[left] <= nums[right])
            return nums[left];
        else if (left+1 == right) {
            return Math.min(nums[left], nums[right]);
        } else {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[left]) {
                return findMin(nums, mid, right);
            } else {
                return findMin(nums, left, mid);
            }
        }
    }
}