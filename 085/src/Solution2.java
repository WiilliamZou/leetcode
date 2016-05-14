import java.util.Stack;

public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int result = 0;
        for(int i = 0; i < matrix.length; i ++){
            updateHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }

        return result;
    }

    private void updateHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }

    public int largestInLine(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0, n = height.length;
        while (i < n) {
            while (!stack.empty() && height[i] < height[stack.peek()]) {
                max = Math.max(max, height[stack.pop()] * (i - (stack.empty() ? 0 : stack.peek()+1)));
            }
            stack.push(i++);
        }
        while (!stack.empty()) {
            max = Math.max(max, height[stack.pop()] * (i - (stack.empty() ? 0 : stack.peek()+1)));
        }
        return max;
    }
}

