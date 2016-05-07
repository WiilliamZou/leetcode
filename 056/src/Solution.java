import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty())
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval hold = intervals.get(0);
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (hold.end >= current.start) {
                hold.end = Math.max(current.end, hold.end);
            } else {
                result.add(hold);
                hold = current;
            }
        }
        result.add(hold);
        return result;

    }
}