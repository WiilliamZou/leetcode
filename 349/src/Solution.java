import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }
        for (int i: nums2) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
}