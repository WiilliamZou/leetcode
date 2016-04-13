import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yunxiaozou on 4/12/16.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] * (-1);
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> current = new ArrayList<>();
                    current.add(i);
                    current.add(left);
                    current.add(right);
                    result.add(current);
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}