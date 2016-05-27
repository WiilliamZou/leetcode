import java.util.PriorityQueue;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.remove(); // if the size exceeds, remove min element.
        }
        return pq.remove();
    }
}
