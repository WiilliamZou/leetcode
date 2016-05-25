import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/24/16.
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Solution2 {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the start number we need to find
        // what is start mean?
        // the start of start boundary?
        int start = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < start) continue;

            // continue to find the start one
            if (a[i] == start) {
                start++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(start, a[i] - 1));

            // now we need to find the start number
            start = a[i] + 1;
        }

        // do a final check
        if (start <= hi) res.add(getRange(start, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
