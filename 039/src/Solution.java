
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
        if (candidates == null) return result;
        Arrays.sort(candidates);
        ArrayList<Integer> current = new ArrayList<>();
        dfs(candidates,target, 0, current,result);
        return result;
    }

    private void dfs(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result) {

        if (index == candidates.length || target < 0) {
            return;
        }
        dfs(candidates, target, index+1, current, result);
        if (index == 0 || candidates[index] != candidates[index-1]) {
            current.add(candidates[index]);
            if (target == 0) {
                List<Integer> list = new ArrayList<>(current);
                result.add(list);
            } else {
                dfs(candidates, target-candidates[index],index+1, current, result);
                dfs(candidates, target-candidates[index],index, current, result);
            }
            current.remove(current.size()-1);
        }
    }
}