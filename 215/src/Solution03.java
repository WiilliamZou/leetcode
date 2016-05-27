import java.util.PriorityQueue;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution03 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length-1, nums.length-k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if(nums[i] <= pivot) {
                swap(nums, left++,i);
            }
        }
        swap(nums,left,end);
        if (left == k) {
            return nums[left];
        } else if (left < k) {
            return findKthLargest(nums, left+1, end, k);
        } else {
            return findKthLargest(nums, start, left-1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
