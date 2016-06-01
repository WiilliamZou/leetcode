import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 1;
        n = n - 1;
        int cur = 1;
        Deque<Integer>[] queues = new Deque[3];
        for (int i = 0; i < 3; i++) {
            queues[i] = new ArrayDeque<>();
        }

        while (n != 0) {
            queues[0].addLast(cur * 2);
            queues[1].addLast(cur * 3);
            queues[2].addLast(cur * 5);
            for (int i = 0; i < 3; i++) {
                while (!queues[i].isEmpty() && queues[i].peekFirst() <= cur) {
                    queues[i].removeFirst();
                }
            }
            int next = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < 3; i++) {
                if (!queues[i].isEmpty() && queues[i].peekFirst() < next) {
                    next = queues[i].peekFirst();
                    index = i;
                }
            }
            cur = next;
            n--;
        }
        return  cur;
    }
}