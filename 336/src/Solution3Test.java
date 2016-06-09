import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 6/9/16.
 */
public class Solution3Test {
    @org.junit.Test
    public void palindromePairs() throws Exception {
        Solution3 sol = new Solution3();
        List<List<Integer>> result = sol.palindromePairs(new String[]{"aaa", "aa"});
        for (List<Integer> pair : result) {
            System.out.println(pair.get(0) + "," + pair.get(1));
        }
    }

}