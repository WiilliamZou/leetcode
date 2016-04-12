/**
 * Created by yunxiaozou on 4/12/16.
 *
 * '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 dynamic programming.
 */
public class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char pChar = p.charAt(j-1);
                if (pChar == '*') {
                    //0 preceding
                    if (j-2 >= 0)
                        dp[i][j] |= dp[i][j-2];
                    // 1 preceding
                    if (i > 0 && j-2 >= 0 && (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)))
                        dp[i][j] |= dp[i-1][j];
                    // +1 preceding.
                    if (i > 1 && j > 0 && s.charAt(i-1) == s.charAt(i-2))
                        dp[i][j] |= dp[i-1][j-1];
                } else if (i > 0 && (pChar == '.'|| (s.charAt(i-1) == p.charAt(j-1)))) {
                    dp[i][j] |= dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}