/**
 * Created by yunxiaozou on 5/6/16.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int start = 0;
        int boundary = nums[start];
        while (true){
            if (boundary >= nums.length-1) {
                return true;
            }
            int newBoundary = boundary;
            for (int i = start + 1; i <= boundary; i++) {
                if (newBoundary < i + nums[i])
                    newBoundary = i+nums[i];
            }

            if (newBoundary == boundary)
                return false;
            start = boundary;
            boundary = newBoundary;
        }
    }
}