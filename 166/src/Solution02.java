import java.util.HashMap;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class Solution02 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer result = new StringBuffer();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(sign);
        result.append(num/den);
        long remainder = num % den;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<>();
        while (!hashMap.containsKey(remainder) && remainder != 0) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }

        if (remainder != 0) {
            int index = hashMap.get(remainder);
            result.insert(index, "(");
            result.append(")");
        }
        return result.toString();
    }
}
