import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c,0) + 1);

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar)-1);
                if (map.get(rightChar) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (minLen > right-left+1) {
                    minLen = right-left+1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar)+1);
                    if (map.get(leftChar) > 0)
                        count--;
                }
                left++;
            }
        }
        if (minLen > s.length()) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}