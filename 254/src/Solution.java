import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(2, n, result, curr);
        return result;
    }

    private void dfs(int start, int n, List<List<Integer>> result, List<Integer> curr) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                curr.add(i);
                int remainder = n / i;
                if (remainder < i) continue;
                curr.add(remainder);
                result.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
                dfs(i, remainder, result, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}