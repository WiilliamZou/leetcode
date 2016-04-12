/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public int myAtoi(String str) {
        long output = 0;
        boolean positive = true;
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            if (output > ((long) Integer.MAX_VALUE) * 10)
                break;
            char c = str.charAt(i);

            if (c == '-' || c == '+') {
                if (i != 0) {
                    return 0;
                }
                if (c == '-')
                    positive = false;
            } else if (Character.isDigit(c)) {
                output = 10 * output + (c - '0');
            } else
                break;
        }
        if (output != 0 && !positive) {
            output = -1 * output;
            positive = true;
        }
        if (output > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (output < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) output;
    }
}