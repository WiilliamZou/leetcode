public class Solution3 {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }

    private int findPeakElement(int[] nums, int left, int right) {
        if (left == right) return left;
        if (left == right-1) {
            if (nums[left] < nums[right]) {
                return right;
            } else {
                return left;
            }
        }
        int mid = left + (right-left)/2;
        if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
            return mid;
        } else if (nums[mid] < nums[mid+1]){
            return findPeakElement(nums, mid+1, right);
        } else {
            return findPeakElement(nums, left, mid-1);
        }
    }
}