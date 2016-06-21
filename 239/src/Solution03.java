import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yunxiaozou on 6/20/16.
 */
public class Solution03 {
    public int[] maxSlidingWindow(int[] a, int k) {
        List<Integer> result = new ArrayList<>();
        MonoQueue mq = new MonoQueue();
        k = Math.min(k, a.length);
        int i;
        for (i = 0; i < k-1; ++i) {
            mq.add(a[i]);
        }
        for (; i < a.length; ++i) {
            mq.add(a[i]);
            result.add(mq.max());
            mq.remove();
        }
        int[] ret = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            ret[j] = result.get(j);
        }
        return ret;

    }

}
class MonoQueue {
    Deque<int[]> m_deque = new ArrayDeque<>();
    public void add(int val) {
        int count = 0;
        while (!m_deque.isEmpty() && m_deque.peekLast()[0] < val) {
            count += m_deque.peekLast()[1]+1;
            m_deque.removeLast();
        }
        m_deque.addLast(new int[]{val, count});
    }
    public int max() {
        return m_deque.peekFirst()[0];
    }
    public void remove() {
        if (m_deque.peekFirst()[1] > 0) {
            m_deque.peekFirst()[1]--;
            return;
        }
        m_deque.removeFirst();
    }
}
