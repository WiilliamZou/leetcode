import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class Solution02 {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<>();

        int start = lo;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < start) continue;

            if (a[i] == start) {
                start++;
                continue;
            }

            res.add(getRange(start, a[i]-1));
            start = a[i] + 1;
        }
        if (start <= hi) res.add(getRange(start, hi));
        return res;
    }

    private String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
