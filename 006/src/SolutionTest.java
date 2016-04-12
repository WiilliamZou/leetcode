import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @Test
    public void testConvert() {
        Solution sol = new Solution();
        assertEquals("PAHNAPLSIIGYIR", sol.convert("PAYPALISHIRING", 3));
    }
}