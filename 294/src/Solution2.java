/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution2 {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        //like brute force.
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);

                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }

}
