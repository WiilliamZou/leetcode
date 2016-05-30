import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/30/16.
 */
public class Solution02 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n ,2);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> item, int n, int start) {
        if (n <= 1 && item.size() > 1) {
            result.add(new ArrayList<>(item));
        } else {
            for (int i = start; i<= n; i++) {
                if (n % i == 0) {
                    item.add(i);
                    dfs(result, item, n/i, i);
                    item.remove(item.size()-1);
                }
            }
        }
    }
}
