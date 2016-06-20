public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                exch(nums, i++, left++); // guarantee i >= left
            } else if (nums[i] == 2){
                exch(nums, i, right--);
            } else {
                i++;
            }
        }
    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}