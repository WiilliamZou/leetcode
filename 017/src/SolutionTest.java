import org.testng.annotations.Test;

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void letterCombinations() throws Exception {
        Solution sol = new Solution();
        MyHelper.printCollection(sol.letterCombinations("2"));
    }

}