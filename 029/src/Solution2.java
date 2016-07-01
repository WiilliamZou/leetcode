/**
 * Created by yunxiaozou on 4/13/16.
 */
public class Solution2 {
    public int divide(int dividend, int divisor) {
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);

        long ret = 0;
        while (divd >= divs) {
            int counter = 0;
            while (divd >= (divs << counter)) { // keep multiply by 2 until divs > divd
                counter++;
            }
            counter--;  // rollback counter so that (divs<<counter) <= divd
            ret += 1L << counter;  // quotient
            divd -= divs << counter;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            ret = -ret;
        System.out.print(ret);
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else  {
            return (int) ret;
        }
    }
}