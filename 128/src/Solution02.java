import java.util.HashSet;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/19/16.
*/
public class Solution02 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num: nums) set.add(num);
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int val = num;
                while(set.remove(val++));
                max = Math.max(max, val-num-1);
            }
        }
        return max;
    }
}
