import java.math.BigInteger;

/**
 * Created by yunxiaozou on 6/5/16.
 */
public class Solution02 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0') break;
            for (int j = i+1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second+1) break;
                while (third < n) {
                    BigInteger firstNum = new BigInteger(num.substring(first, second));
                    BigInteger secondNum = new BigInteger(num.substring(second, third));
                    BigInteger resultNum = firstNum.add(secondNum);
                    if (num.substring(third).startsWith(resultNum.toString())) {
                        first = second;
                        second = third;
                        third += resultNum.toString().length();
                    } else {
                        break;
                    }
                }
                if (third == n) return true;
            }
        }
        return false;
    }
}
