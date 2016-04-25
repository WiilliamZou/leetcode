import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 4/24/16.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        ArrayList<Integer> current = new ArrayList<>();
        dfs(nums, current, result);
        return result;
    }

    private void dfs(int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!current.contains(nums[i])) {
                    current.add(nums[i]);
                    dfs(nums, current, result);
                    current.remove(current.size()-1);
                }
            }
        }
    }
}
