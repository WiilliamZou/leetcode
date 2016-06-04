import java.util.HashMap;


/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution03 {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2)
            return false;
        HashMap<String, Boolean> winMap = new HashMap<>();
        return helper(s, winMap);
    }

    private boolean helper(String s, HashMap<String, Boolean> winMap) {
        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0,i) + "--" + s.substring(i+2);
                if (!helper(t, winMap)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }
}
