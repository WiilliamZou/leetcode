import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 6/7/16.
 */
public class Solution04 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null) return res;
        DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }

    private void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if (i == c.length) {
            if (num != 0) sb.append(num);
            res.add(sb.toString());
        } else {
            DFS(res, sb, c, i+1, num+1);

            if (num != 0) sb.append(num);
            DFS(res, sb.append(c[i]), c, i+1, 0);
        }
        sb.setLength(len);
    }
}
