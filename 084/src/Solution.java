import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0, n = heights.length;
        while (i < n) {
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                max = Math.max(max, heights[stack.pop()] * (i - (stack.empty() ? 0 : stack.peek()+1)));
            }
            stack.push(i++);
        }
        while (!stack.empty()) {
            max = Math.max(max, heights[stack.pop()] * (i - (stack.empty() ? 0 : stack.peek()+1)));
        }
        return max;
    }
}