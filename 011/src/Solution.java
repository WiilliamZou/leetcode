/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public int maxArea(int[] height) {
        int max= 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int current = Math.min(height[left], height[right]) * (right-left);
            if (current > max)
                max = current;
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return max;

    }
}
