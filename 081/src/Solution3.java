/**
 * Created by yunxiaozou on 5/12/16.
 */
public class Solution3 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] == nums[l]) {
                l++;
            } else if (nums[m] > nums[l]) {
                if (target < nums[m] && target >= nums[l]) r = m - 1;
                else l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}
