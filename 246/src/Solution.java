import java.util.HashMap;

public class Solution {
    HashMap<Character, Character> map = new HashMap<>();
    public boolean isStrobogrammatic(String num) {
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6', '9');
        map.put('9','6');
        if (num == null || num.length() == 0) return true;
        int left = 0;
        int right = num.length()-1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}