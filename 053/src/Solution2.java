public class Solution2 {
    public int maxSubArrayRec(int[] nums, int i, int j) {
        if(i==j)
            return nums[i];
        int mid = (i + j) / 2;
        int leftMax = maxSubArrayRec(nums,i,mid);
        int rightMax = maxSubArrayRec(nums,mid+1,j);
        int subMax = Math.max(leftMax,rightMax);

        int leftContiguousMax = nums[mid];
        int leftSum = nums[mid];
        for(int k=mid-1; k>=i; k--) {
            leftSum += nums[k];
            if(leftSum > leftContiguousMax)
                leftContiguousMax = leftSum;
        }

        int rightContigousMax = nums[mid+1];
        int rightSum = nums[mid+1];
        for(int k=mid+2; k<=j; k++) {
            rightSum += nums[k];
            if(rightSum > rightContigousMax)
                rightContigousMax = rightSum;
        }

        return Math.max(subMax,leftContiguousMax+rightContigousMax);
    }

    public int maxSubArray(int[] nums) {
        return maxSubArrayRec(nums,0,nums.length-1);
    }
}