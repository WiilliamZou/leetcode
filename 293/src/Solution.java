import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.startsWith("++",i)) {
                char[] strArr = s.toCharArray();
                strArr[i] = '-';
                strArr[i+1] = '-';
                result.add(new String(strArr));
            }
        }
        return result;

    }
}