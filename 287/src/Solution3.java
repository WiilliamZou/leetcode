/**
 * Created by yunxiaozou on 6/24/16.
 */
public class Solution3 {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            int count = 0;
            for (int i: nums) {
                if (i <= mid) {
                    count += 1;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
