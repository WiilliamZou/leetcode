public class Solution6 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start, end;
        int sum, minLen;
        start = end = 0;
        sum = 0;
        minLen = Integer.MAX_VALUE;
        while (end <= nums.length) {
            if (sum < s) {
                if (end == nums.length)
                    break;
                else {
                    sum += nums[end++];
                }
            } else {
                minLen = Math.min(minLen, end-start);
                sum -= nums[start++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}