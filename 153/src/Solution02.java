/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution02 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length-1;
        while (left < right - 1) {
            int mid = (right+left)/2;
            if (nums[mid] > nums[right]) {left = mid;}
            else {right = mid;}
        }
        if (nums[left] > nums[right]) {return nums[right];}
        else return nums[left];
    }

}
