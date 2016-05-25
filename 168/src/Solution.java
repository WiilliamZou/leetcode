import java.util.HashMap;

public class Solution {

    public String convertToTitle(int n) {
        StringBuffer a = new StringBuffer();
        while (n > 0) {
            char c = (char)('A' + (n-1) % 26);
            a.insert(0, c);
            n = (n-1) / 26;
        }
        return a.toString();
    }
}