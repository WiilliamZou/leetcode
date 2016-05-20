import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/20/16.
 */
public class Solution02 {
    public List<String> wordBreak(String s, Set<String> wordDict){
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    private List<String> dfs(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for (String sub: subList) {
                    res.add(word + (sub.isEmpty()? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
