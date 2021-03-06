/**
 * Created by yunxiaozou on 4/14/16.
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        int j = nums.length-1;
        if (i >= 0) {
            while (nums[i] >= nums[j]) j--;
            swap(nums, i,j);
        }
        reverse(nums, i+1, nums.length-1);


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
