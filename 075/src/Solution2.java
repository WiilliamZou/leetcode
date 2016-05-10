public class Solution2 {
    public void sortColors(int[] nums) {
        if (nums==null || nums.length<2) { return; }
        int i=0, j=0, k=nums.length-1;
        while (j <= k) {
            if (nums[j] == 0) { swap(nums, i++, j++); }  // should swap with whatever at index i; note that i++ AND j++
            else if (nums[j] == 1) { ++j; }
            else { swap(nums, j, k--); }  // nums[j]==2, should swap with whatever at index k, then --k 
        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}