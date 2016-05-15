import java.util.LinkedList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/15/16.
 */
public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        int[] curr = new int[4];
        dfs(result, s, 0,  curr, 0);
        return result;
    }

    void dfs(List<String> acc, String s, int idx, int[] curr, int segment){
        if(segment == 4 && idx == s.length() ){
            acc.add(curr[0] + "." + curr[1] + "."+ curr[2] + "." + curr[3]);
            return ;
        }else if(segment == 4 || idx == s.length() ){
            return ;
        }
        // len 代表当前segment 的长度。
        for(int len = 1; len <= 3 && idx + len <= s.length() ; len ++){
            int val = Integer.parseInt(s.substring(idx, idx + len));
            // range check, no leading 0.
            if(val > 255 || len >= 2  && s.charAt(idx) == '0')
                break;

            curr[segment] = val;
            dfs(acc, s, idx + len, curr, segment + 1);
            curr[segment] = -1; // for debug.
        }
    }
}
