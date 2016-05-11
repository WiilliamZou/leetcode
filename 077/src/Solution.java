import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k > n) return result;
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length;i++)
            numbers[i] = i+1;
        List<Integer> current = new ArrayList<>();
        dfs(numbers, 0, k, current, result);
        return result;
    }

    private void dfs(int[] numbers, int index, int k, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) result.add(new ArrayList<>(current));
        else {
            for (int i = index; i < numbers.length-k+1;i++) {
                current.add(numbers[i]);
                dfs(numbers,i+1, k-1, current, result);
                current.remove(current.size()-1);
            }
        }
    }
}