import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        dfs(nums, 0, result, current);
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
        if (index == nums.length) result.add(new ArrayList<>(current));
        else {
            dfs(nums, index+1, result, current);
            current.add(nums[index]);
            dfs(nums, index+1, result, current);
            current.remove(current.size()-1);

        }
    }
}