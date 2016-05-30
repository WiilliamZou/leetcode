import java.util.Stack;

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int flag = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < flag) return false;
            while (!stack.empty() && stack.peek() < num) {
                flag = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}