import java.util.HashMap;


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        char currentChar = 'A';
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), currentChar++);
            }
            buffer.append(map.get(s.charAt(i)));
        }
        return buffer.toString();
    }
}