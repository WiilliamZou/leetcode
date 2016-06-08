import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution02 {
    public int maxSubArrayLen(int[] nums, int k ) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i-1];
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]-k))
                max = Math.max(max, i-map.get(nums[i]-k));
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }
        return max;
    }
}
