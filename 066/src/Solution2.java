import java.util.Arrays;

/**
 * Created by yunxiaozou on 5/9/16.
 */
public class Solution2 {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int temp = digits[i] + carry;
            if (temp > 9) {
                temp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result[i+1] = temp;
        }
        if (carry == 1)
            result[0] = 1;
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            return result;
        }
    }
}