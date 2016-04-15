import java.util.Stack;

/**
 * Created by yunxiaozou on 4/15/16.
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        int[] dp = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    int j = stack.pop();
                    int current = i - j + 1;
                    if (j > 0) current += dp[j - 1];
                    dp[i] = current;
                    if (max < current) max = current;
                }
            }
        }
        return max;
    }
}