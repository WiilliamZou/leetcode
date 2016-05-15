import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 0) return result;
        result.add(0);
        return grayCode(n, 0, result);

    }

    private List<Integer> grayCode(int n, int index, List<Integer> result) {
        if (index == n) {
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            for (int number : result) {
                int newNumber = number + (1 << index);
                temp.add(newNumber);
            }
            Collections.reverse(temp);
            result.addAll(temp);
        }
        return grayCode(n, index + 1, result);
    }
}
