/**
 * Created by yunxiaozou on 4/12/16.
 * assume both nums and target are both positive integers.
 */
public class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        Integer[] array = new Integer[target];
        for (int i = 0; i < nums.length; i++) {
            if (array[target-nums[i]] != null) {
                return new int[] {array[target-nums[i]], i};
            }else {
                array[nums[i]] = i;
            }
        }
        return null;
    }
}
