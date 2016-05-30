import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        for (Interval interval : intervals) {
            pq.add(interval);
        }
        Interval pre = null;
        while (!pq.isEmpty()) {
            Interval curr = pq.remove();
            if (pre != null && pre.end > curr.start)
                return false;
            pre = curr;
        }
        return true;
    }
}