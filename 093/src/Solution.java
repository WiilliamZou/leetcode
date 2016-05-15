import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int[] curr = new int[4];
        dfs(s, 0, curr, 0, result);
        return result;
    }

    private void dfs(String s, int idx, int[] curr, int seg, List<String> result) {
        if (idx == s.length() && seg == 4) {
            result.add(curr[0] + "." + curr[1] + "." + curr[2] + "." + curr[3]);
            return;
        } else if (idx == s.length() || seg == 4) {
            return;
        }
        else {
            for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
                int val = Integer.parseInt(s.substring(idx, idx+len));
                if (val > 255 || (len >= 2 && s.charAt(idx) == '0'))
                    break;
                curr[seg] = val;
                dfs(s, idx+len, curr, seg+1, result);
                curr[seg] = 0;
            }
        }
    }
}