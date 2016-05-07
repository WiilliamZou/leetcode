import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yunxiaozou on 5/7/16.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval hold = intervals.get(0);
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= hold.end) {
                hold.end = Math.max(hold.end, current.end);
            } else {
                result.add(hold);
                hold = current;
            }

        }
        result.add(hold);
        return result;
    }
}