public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        long sum = 0;
        long expected = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            expected += i;
        }
        expected += i;
        return (int)(expected - sum);
    }
}