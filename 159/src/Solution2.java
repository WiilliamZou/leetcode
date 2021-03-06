import java.util.HashMap;

public class Solution2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // two pointers and map style.
        if(s.length() < 1) return 0;
        // the rightmost index of character
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(map.size() <= 2) {
                char c = s.charAt(hi);
                map.put(c, hi);
                hi++;
            }
            if(map.size() > 2) {
                int leftMost = s.length();
                for(int i : map.values()) {
                    leftMost = Math.min(leftMost,i);
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