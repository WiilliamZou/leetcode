import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    dfs. 每个位置都有选与不选两个选项, 也可以看成遍历一棵二叉树, 向左走选, 向右走不选
*/
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) { return ans; }
        Arrays.sort(nums);  // non-descending order
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) { ans.add(new ArrayList<Integer>(list)); return; }
        dfs(ans, nums, list, index+1);  // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index+1);  // pick the number at this index
        list.remove(list.size()-1);
    }
}