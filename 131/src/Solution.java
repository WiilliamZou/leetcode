import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) return result;
        List<String> curr = new ArrayList<>();
        dfs(s, 0, curr, result);
        return result;
    }

    private void dfs(String s, int index, List<String> curr, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));

        } else {
            for (int i = index; i < s.length(); i++) {
                String currPart = s.substring(index, i+1);
                if (isPalid(currPart)) {
                    curr.add(currPart);
                    dfs(s, i+1, curr, result);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
    private boolean isPalid(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}