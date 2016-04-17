/**
 * Created by yunxiaozou on 4/16/16.
 *
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int[] output = new int[num1.length()+ num2.length()];
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int temp = digit1 * digit2;
                output[i+j] += (temp + output[i+j+1])/10;
                output[i+j+1] = (temp + output[i+j+1])%10;

            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int digit : output) {
            if (buffer.length() != 0 || digit != 0)
                buffer.append(digit);
        }
        if (buffer.length() == 0)
            buffer.append(0);
        return buffer.toString();
    }
}