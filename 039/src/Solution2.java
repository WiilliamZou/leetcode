/**
 * Created by yunxiaozou on 4/16/16.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int[] cand, int remain, int from) {
        if (remain < 0) { return; }
        if (remain == 0) { ans.add(new ArrayList<Integer>(list)); return; }
        for (int i=from; i<cand.length; ++i) {  //cand[] sorted; from is the starting point of picking elements at this level
            list.add(cand[i]);
            dfs(ans, list, cand, remain-cand[i], i);
            list.remove(list.size()-1);
        }
    }
}