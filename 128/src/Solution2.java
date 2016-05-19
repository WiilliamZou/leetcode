/**
 * Created by yunxiaozou on 5/19/16.
 */
import java.util.*;
public class Solution2 {
    public class Solution {
        public int longestConsecutive(int[] nums) {
                Set<Integer> set = new HashSet<>();
            int max = 0;
            for(int num : nums) set.add(num);
            for(int num : nums) if (!set.contains(num-1)) {
                int val = num;
                while(set.remove(val++));
                max = Math.max(max, val-num-1);
            }
            return max;
        }
    }
}
