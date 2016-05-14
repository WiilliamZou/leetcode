import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public boolean isScramble(String s1, String s2) {
        int len= s1.length();
        if(s2.length()!=len) return false;
        if(s1.equals(s2)) return true;
        Map<Character,Integer> checkPermutation = new HashMap<Character,Integer>();
        for(int i = 0; i < len; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if(checkPermutation.containsKey(a)) checkPermutation.put(a,checkPermutation.get(a)+1);
            else checkPermutation.put(a,1);
            if(checkPermutation.containsKey(b)) checkPermutation.put(b,checkPermutation.get(b)-1);
            else checkPermutation.put(b,-1);
        }
        for(char c : checkPermutation.keySet()) if(checkPermutation.get(c)!=0) return false;

        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,len),s2.substring(i,len))) return true;
            else if(isScramble(s1.substring(0,i),s2.substring(len-i,len))&&isScramble(s1.substring(i,len),s2.substring(0,len-i))) return true;
        }
        return false;
    }
}