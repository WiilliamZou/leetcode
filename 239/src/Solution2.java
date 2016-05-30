import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.removeFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.removeLast();
            }
            // q contains index... r contains content
            q.addLast(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peekFirst()];
            }
        }
        return r;
    }
}
