import java.util.HashMap;

/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution02 {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<>();
            int samex = 1;
            int samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (points[j].x == points[i].x && points[j].y == points[i].y) {
                        samep++;
                    } else if (points[j].x == points[i].x) {
                        samex++;
                    } else {
                        double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                        hm.put(k, hm.getOrDefault(k,1)+1);
                        result = Math.max(result, hm.get(k) + samep);
                    }
                }
            }
            result = Math.max(result, samep + samex);
        }
        return result;
    }
}
