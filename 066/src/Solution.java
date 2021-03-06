import java.util.Arrays;

/**
 * Created by yunxiaozou on 5/9/16.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int temp = digits[i] + carry;
            if (temp > 9) {
                temp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            digits[i] = temp;
            if (carry == 0)
                return digits;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}