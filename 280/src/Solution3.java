import java.util.Arrays;

/**
 * Created by yunxiaozou on 6/2/16.
 */
public class Solution3 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i+=2) {
            swap(nums, i, i+1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
