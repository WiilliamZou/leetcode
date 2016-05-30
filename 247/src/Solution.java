import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Character, Character> map = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6', '9');
        map.put('9', '6');
        char[] curr = new char[n];
        if (n < 1) return result;
        dfs(0, n-1, curr, result);
        return result;
    }

    private void dfs(int left, int right, char[] curr, List<String> result) {
        if (left > right) {
            result.add(new String(curr));
        } else {
            for (char leftChar: map.keySet()) {
                char rightChar = map.get(leftChar);
                if (left == 0 && curr.length > 1) {
                    if (leftChar == '0') continue;
                }
                if (left == right) {
                    if (leftChar != rightChar) continue;
                }
                curr[left] = leftChar;
                curr[right] = rightChar;
                dfs(left+1, right-1, curr, result);
            }
        }
    }
}