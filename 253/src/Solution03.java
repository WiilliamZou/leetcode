import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yunxiaozou on 5/30/16.
 */
public class Solution03 {
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval i: intervals) {
            map.put(i.start, map.getOrDefault(i.start,0)+1);
            map.put(i.end, map.getOrDefault(i.end,0)-1);
        }
        int maxRoom = 0;
        int curRoom = 0;
        for (int i: map.keySet()) {
            curRoom += map.get(i);
            maxRoom = Math.max(maxRoom, curRoom);
        }
        return maxRoom;
    }
}
