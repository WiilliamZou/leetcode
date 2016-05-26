import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution03 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[(i+nums.length-k)%nums.length]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.get(i);
        }

    }
}
