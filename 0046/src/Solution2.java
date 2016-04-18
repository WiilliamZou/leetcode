/**
 * Created by yunxiaozou on 4/18/16.
 */
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        dfs(nums, lists, new ArrayList<Integer>());
        return lists;
    }

    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            dfs(nums, lists, cur);
            cur.remove(cur.size() - 1);
        }
    }
}