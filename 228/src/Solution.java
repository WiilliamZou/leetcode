import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int start = nums[0];
        int end = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == (end+1))
                end++;
            if (nums[i] > end) {
                output(start, end, result);
                start = end = nums[i];
            }
        }
        output(start, end, result);
        return result;
    }

    private void output(int start, int end, List<String> result) {
        String output = null;
        if (start == end){
            output = String.valueOf(start);
        } else {
            output = String.format("%d->%d",start, end);
        }
        result.add(output);
    }
}