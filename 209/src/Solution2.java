public class Solution2 {
    public int minSubArrayLen(int sum, int[] nums) {
        // java dynamic window problem
        // [start, end)
        int minlen = Integer.MAX_VALUE;
        int curSum = 0;
        int start = 0;
        int end = 0;

        while(start < nums.length){
            //if current window doesn't add up to the given sum then 
            //strech the window to right
            if(curSum < sum && end < nums.length){
                curSum += nums[end];
                end++;
            }
            //if current window adds up to at least given sum then
            //we can shrink the window 
            else if(curSum >= sum){
                minlen = Math.min(minlen, end-start);
                curSum -= nums[start];
                start++;
            }
            //cur sum less than required sum but we reach the end 
            else{
                break;
            }
        }

        return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
    }
}