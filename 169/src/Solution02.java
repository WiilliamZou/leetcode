/**
 * Created by yunxiaozou on 5/25/16.
 */
public class Solution02 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        for (int x: nums) {
            if (x != majorityElement) {
                count--;
            }
            else {
                count++;
            }

            if (count <= 0) {
                majorityElement = x;
                count = 1;
            }
        }
        return majorityElement;
    }
}
