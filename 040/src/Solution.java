import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null) return result;
        dfs(new ArrayList<Integer>(), result, candidates, target, 0);
        return result;
    }

    private void dfs(ArrayList<Integer> list, List<List<Integer>> result, int[] candidates, int remain, int from) {
        if (remain == 0) {result.add(new ArrayList<>(list)); return;}
        if (remain < 0) {return; }
        for (int i = from; i < candidates.length; i++) {
            if (i > from && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(list, result, candidates, remain-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}