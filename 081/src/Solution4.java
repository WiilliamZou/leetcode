/**
 * Created by yunxiaozou on 12/26/15.
 */
public class Solution4 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        return search(nums, target, 0, nums.length -1);
    }

    public boolean search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[left] == target)
                return true;
            else if (nums[right] == target)
                return true;
            else if (nums[mid] == nums[left]) {
                left++;
            }
            else if (nums[mid] > nums[left]) {
                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else  {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}