/**
 * Created by yunxiaozou on 5/6/16.
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayRec(nums, 0, nums.length-1);
    }

    private int maxSubArrayRec(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = (left + right)/2;
        int leftMax = maxSubArrayRec(nums, left, mid);
        int rightMax = maxSubArrayRec(nums, mid+1,right);
        int leftContinousMax = nums[mid];
        int rightContinousMax = nums[mid+1];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            if (leftContinousMax < leftSum)
                leftContinousMax = leftSum;
        }
        for (int i = mid+1; i <= right; i++) {
            rightSum += nums[i];
            if (rightContinousMax < rightSum)
                rightContinousMax = rightSum;
        }
        return Math.max(leftContinousMax + rightContinousMax, Math.max(leftMax, rightMax));
    }
}
