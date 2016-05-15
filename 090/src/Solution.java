import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, used, current, result);
        return result;
    }

    private void dfs(int index, int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
        }
        else {
            if (index > 0 && nums[index] == nums[index-1] && !used[index-1]) {
                dfs(index+1, nums, used, current, result);
            } else {
                dfs(index+1, nums, used, current, result);
                current.add(nums[index]);
                used[index] = true;
                dfs(index+1, nums, used, current, result);
                used[index] = false;
                current.remove(current.size()-1);
            }
        }
    }
}