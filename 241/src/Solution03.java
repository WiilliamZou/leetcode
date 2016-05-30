import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunxiaozou on 5/30/16.
 */
public class Solution03 {
    HashMap<String, List<Integer>> cache = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (cache.containsKey(input)) return cache.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0,i);
                String b = input.substring(i+1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x: al) {
                    for (int y: bl) {
                        if (c == '-') {
                            res.add(x-y);
                        }else if (c == '+') {
                            res.add(x+y);
                        } else {
                            res.add(x*y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        cache.put(input, res);
        return res;
    }

}
