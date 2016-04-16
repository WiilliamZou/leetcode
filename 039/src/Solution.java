
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (candidates == null) return result;
        Arrays.sort(candidates);
        dfs(candidates, result, current, target, 0);
        return result;
    }

    private void dfs(int[] candidates, List<List<Integer>> result, List<Integer> current, int remainder, int from) {
        if (remainder == 0) {result.add(new ArrayList<>(current)); return;}
        if (remainder < 0) return;
        for (int i = from; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, result, current, remainder-candidates[i], i);
            current.remove(current.size()-1);
        }
    }
}