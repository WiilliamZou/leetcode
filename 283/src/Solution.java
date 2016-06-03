public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int zeroIndex = 0;
        for (int num: nums) {
            if (num != 0)
                nums[zeroIndex++] = num;
        }
        while (zeroIndex < nums.length) {
            nums[zeroIndex++] = 0;
        }
    }
}