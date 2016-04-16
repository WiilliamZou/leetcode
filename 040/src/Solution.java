import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        dfs(new ArrayList<Integer>(), result, candidates, target, 0);
        return result;
    }

    private void dfs(ArrayList<Integer> list, List<List<Integer>> result, int[] candidates, int remain, int from) {
        if (remain == 0) {result.add(new ArrayList<>(list)); return;}
        if (remain < 0) {return; }
        for (int i = from; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(list, result, candidates, remain-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}