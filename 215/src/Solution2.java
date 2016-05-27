import java.util.PriorityQueue;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution2 {
    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}
