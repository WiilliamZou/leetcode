import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class Solution02 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;
        int count1, count2, candidate1, candidate2;
        count1 = count2 = candidate1 = candidate2 = 0;
        for (int num: nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num: nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        if (count1 > nums.length/3) rst.add(candidate1);
        if (count2 > nums.length/3) rst.add(candidate2);
        return rst;
    }
}
