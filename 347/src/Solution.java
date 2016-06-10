import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for (Integer key: map.keySet()) {
            queue.add(new int[]{key, map.get(key)});
            if (queue.size() > k) {
                queue.remove();
            }
        }
        while (!queue.isEmpty()) result.add(0, queue.remove()[0]);
        return result;
    }
}