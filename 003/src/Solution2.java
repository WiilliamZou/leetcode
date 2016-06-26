import java.util.HashMap;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int left = 0;
        int max = 0;
        for (i = 0; i <= s.length(); i++) {
            max = Math.max(max, i-left);
            if (i < s.length()) {
                if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                    left = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i), i);
            }

        }
        return max;
    }
}