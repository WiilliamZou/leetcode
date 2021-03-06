import java.util.Set;

/**
 * Created by yunxiaozou on 5/20/16.
 */
public class Solution2 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // the maximum length;
        int maxWord = getMax(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            int start = Math.max(1, i - maxWord);
            for (int j = start; j <= i; j++) {
                // check cut [1...j-1] and [j,i] (1-based)
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    private int getMax(Set<String> wordDict) {
        int max = 0;
        for (String str : wordDict) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
