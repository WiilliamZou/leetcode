import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution02 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> resSet = new HashSet<>();
        if (s == null || s.length() <= 10) {
            return res;
        }
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i <= len-10; i++) {
            String sub = s.substring(i, i+10);
            if (set.contains(sub)) {
                resSet.add(sub);
            } else {
                set.add(sub);
            }
        }
        res.addAll(resSet);
        return res;
    }
}
