import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int num1, num2, counter1, counter2;
        num1 = num2 = counter2 = counter1 = 0;
        for (int num : nums) {

        }

        int k = nums.length/3;
        counter1 = counter2 = 0;
        for (int num: nums) {
            if (num == num1) {
                counter1++;
            } else if (num == num2) {
                counter2++;
            }
        }
        if (counter1 > k)
            result.add(num1);
        if (counter2 > k)
            result.add(num2);
        return result;
    }
}