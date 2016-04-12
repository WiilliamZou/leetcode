import java.util.HashMap;

/**
 * Created by yunxiaozou on 4/12/16.
 * Given a string, find the length of the longest substring
 * without repeating characters. For example, the longest substring without repeating l
 * etters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the
 * longest substring is "b", with the length of 1.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //<char, index>
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int i;
        int max = 0;
        for (i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                max = Math.max(max, i - left);
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
        }
        max = Math.max(max, i - left);
        return max;
    }
}