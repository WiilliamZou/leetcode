import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i: nums1)
            map.put(i, map.getOrDefault(i, 0)+1);
        for (int i: nums2) {
            if (map.containsKey(i)) {
                result.add(i);
                map.put(i, map.get(i)-1);
                if (map.get(i) == 0)
                    map.remove(i);
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            ret[i] = result.get(i);
        return ret;
    }
}