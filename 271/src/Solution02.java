import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 6/1/16.
 */
public class Solution02 {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash+1, slash+1+size));
            i = slash+size+1;
        }
        return ret;
    }
}
