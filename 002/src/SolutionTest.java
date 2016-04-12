

import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void addTwoNumbers()  {
        Solution sol = new Solution();
        ListNode l1 = ListHelper.constructList(new int[]{2,4,3});
        ListNode l2 = ListHelper.constructList(new int[]{5,6,4});
        ListNode expected = ListHelper.constructList(new int[]{7,0,8});
        ListNode actual = sol.addTwoNumbers(l1, l2);
        assertTrue(ListHelper.compareLists(expected, actual));


    }

}