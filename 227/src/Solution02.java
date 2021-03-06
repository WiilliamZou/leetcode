import java.util.Stack;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution02 {
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len-1) {
                if (operator == '-') {
                    stack.push(-num);
                }
                if (operator == '+') {
                    stack.push(num);
                }
                if (operator == '*') {
                    stack.push(stack.pop() * num);
                }
                if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                operator = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i: stack) {
            re += i;
        }
        return re;
    }
}
