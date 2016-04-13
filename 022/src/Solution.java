import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        int left = n;
        int right = n;
        dfs(n, n, buffer, result);
        return result;
    }
    private void dfs(int left, int right, StringBuffer buffer, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(buffer.toString());
        } else {
            if (left > 0) {
                buffer.append('(');
                dfs(left-1, right, buffer, result);
                buffer.deleteCharAt(buffer.length()-1);
            }
            if (right > left) {
                buffer.append(')');
                dfs(left, right-1, buffer, result);
                buffer.deleteCharAt(buffer.length()-1);
            }
        }
    }
}