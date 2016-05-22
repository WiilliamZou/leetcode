import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (false || token.equals("+")
                     || token.equals("-")
                     || token.equals("/")
                     || token.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num1 - num2;
                } else if (token.equals("/")) {
                    result = num1 / num2;
                } else {
                    result = num1 * num2;
                }
                stack.push(result);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}