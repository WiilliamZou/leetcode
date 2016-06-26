/**
 * Created by yunxiaozou on 5/6/16.
 */
public class Solution3 {
    public int jump(int[] nums) {
        int start = 0;
        int boundary = 0;
        int count = 0;
        while (true){
            if (boundary >= nums.length-1) {
                return count;
            }
            int newBoundary = boundary;
            for (int i = start; i <= boundary; i++) {
                if (newBoundary < i + nums[i])
                    newBoundary = i+nums[i];
            }

            if (newBoundary == boundary)
                return -1;
            start = boundary+1;
            boundary = newBoundary;
            count++;
        }
    }
}