import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/14/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void grayCode() throws Exception {
        Solution sol = new Solution();
      //  System.out.println(Arrays.toString(sol.grayCode(0).toArray()));
      //  System.out.println(Arrays.toString(sol.grayCode(1).toArray()));
        System.out.println(Arrays.toString(sol.grayCode(2).toArray()));
    }

}