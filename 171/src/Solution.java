public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += ((int)(c - 'A' + 1)) * ((int)Math.pow(26, s.length()-i-1));
        }
        return sum;
    }
}