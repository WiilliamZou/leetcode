import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunxiaozou on 4/21/16.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null && nums.length == 0)
            return result;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> current = new ArrayList<>();
        dfs(nums, result, current, numMap);
        return result;

    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> current, HashMap<Integer, Integer> numMap) {
        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int currentNum : nums) {
                if (numMap.getOrDefault(currentNum, 0) != 0) {
                    current.add(currentNum);
                    numMap.put(currentNum, numMap.getOrDefault(currentNum,0) - 1);
                    dfs(nums, result, current, numMap);
                    numMap.put(currentNum, numMap.getOrDefault(currentNum,0) + 1);
                    current.remove(current.size()-1);
                }
            }
        }
    }


}