import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 5/22/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void sortList() throws Exception {
        Solution sol = new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        sol.sortList(head);
    }

}