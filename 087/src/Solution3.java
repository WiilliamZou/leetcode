import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public boolean isScramble(String s1, String s2) {
        int len= s1.length();
        if(s2.length()!=len) return false;
        if(s1.equals(s2)) return true;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < len; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if(map.containsKey(a)) map.put(a,map.get(a)+1);
            else map.put(a,1);
            if(map.containsKey(b)) map.put(b,map.get(b)-1);
            else map.put(b,-1);
        }
        for(char c : map.keySet()) if(map.get(c)!=0) return false;

        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,len),s2.substring(i,len))) return true;
            else if(isScramble(s1.substring(0,i),s2.substring(len-i,len))&&isScramble(s1.substring(i,len),s2.substring(0,len-i))) return true;
        }
        return false;
    }
}