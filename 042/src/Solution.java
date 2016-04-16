/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int[] bound = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) max = height[i];
            left[i] = max;
        }
        max = 0;
        for (int i = height.length-1; i >= 0; i--) {
            if (max < height[i]) max = height[i];
            right[i] = max;
        }
        for (int i = 0; i < height.length; i++) {
            bound[i] = Math.min(left[i], right[i]);
        }
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            area += bound[i]-height[i];
        }
        return area;
    }
}