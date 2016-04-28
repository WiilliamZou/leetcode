import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunxiaozou on 4/21/16.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (nums == null || nums.length == 0 ) return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, result, current);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                current.add(nums[i]);
                dfs(nums, used, result, current);
                used[i] = false;
                current.remove(current.size()-1);
            }
        }
    }


}