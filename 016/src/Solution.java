import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Integer sum = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == target) {
                    return current;
                }
                if (sum == null || (Math.abs(target - sum) > Math.abs(target - current))) {
                    sum = current;
                }
                if (current > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sum;
    }
}