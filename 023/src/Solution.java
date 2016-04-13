import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()) {
            ListNode current = queue.poll();
            p.next = current;
            if (current.next != null) {
                queue.offer(current.next);
            }
            p = p.next;
        }
        return fakeHead.next;
    }
}