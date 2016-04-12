/**
 * Created by yunxiaozou on 4/12/16.
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    int max = 0;
    String result = null;

    public String longestPalindrome(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            findPalin(s, i,i);
            findPalin(s, i, i+1);
        }
        return result;
    }
    private void findPalin(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (max < right-left+1) {
                    max = right-left+1;
                    result = s.substring(left,right+1);
                }
                left--;
                right++;
            }else {
                break;
            }
        }
    }
}
