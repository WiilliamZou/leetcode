public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) return 0;
            else if (c == '0') {
                if (i > 0 && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
                    dp[i] = (i > 1) ? dp[i-2] : 1;
                else return 0;
            } else if (c >= '7' && c <= '9') {
                if (i > 0 && s.charAt(i-1) == '1')
                    dp[i] = dp[i-1] + ((i > 1) ? dp[i-2] : 1);
                else
                    dp[i] = (i > 0)? dp[i-1] : 1;
            } else if (c >= '1' && c <= '6') {
                if (i > 0 && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2'))
                    dp[i] = dp[i-1] + ((i > 1) ? dp[i-2] :1);
                else
                    dp[i] = (i>0) ? dp[i-1] : 1;
            }
        }
        return dp[s.length()-1];
    }
}