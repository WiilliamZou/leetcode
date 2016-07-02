import java.util.Arrays;

/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution02 {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            int i  = Arrays.binarySearch(temp, 0, len, x);
            if (i < 0) i = -(i+1);
            temp[i] = x;
            if (i == len) len++;
        }
        System.out.println(Arrays.toString(temp));
        return len;
    }
}
