import java.util.HashMap;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        boolean odd = false;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }
}