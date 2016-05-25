/**
 * Created by yunxiaozou on 5/24/16.
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }
        // invariant: nums[left-1] < nums[left] && num[right] > nums[right+1]
        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // nums[mid+1] can be a peak
                left = mid + 1;
            } else {
                // nums[mid] can be a peak
                right = mid;
            }
        }

        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
