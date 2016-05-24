import java.util.HashMap;

/**
 * Created by yunxiaozou on 5/23/16.
 */
public class Solution02 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while (hi < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(hi);
                map.put(c, hi);
                hi++;
            }
            if (map.size() > 2){
                int leftMost = s.length();
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }
}
