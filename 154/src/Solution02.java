/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution02 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
