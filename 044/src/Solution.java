/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = (i > 0 && dp[i-1][j]) ||
                            dp[i][j-1] ||(i > 0 && dp[i-1][j-1]);
                } else if (i > 0 && (p.charAt(j-1) == '?' ||
                        p.charAt(j-1) == s.charAt(i-1))) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}