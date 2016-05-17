import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;
        List<Integer> init = new ArrayList<>();
        init.add(1);
        result.add(init);
        traverse(result, numRows-1);
        return result;
    }

    private void traverse(List<List<Integer>> result, int num) {
        if (num == 0) return;
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        List<Integer> last = result.get(result.size()-1);
        for (int i = 1; i < last.size(); i++) {
            curr.add(last.get(i-1) + last.get(i));
        }
        curr.add(1);
        result.add(curr);
        traverse(result, num-1);
    }
}