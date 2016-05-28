import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, current, result);
        return result;
    }

    private void dfs(int k, int n, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
        } else if (current.size() == k || n <= 0) {
            return;
        } else {
            int start = (current.size() == 0) ? 1 : current.get(current.size()-1)+1;
            for (int i = start; i <= 9; i++) {
                current.add(i);
                dfs(k, n-i, current, result);
                current.remove(current.size()-1);
            }
        }
    }
}