import java.util.HashSet;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class TwoSum02 {
    Set<Integer> sum;
    Set<Integer> num;

    public TwoSum02() {
        sum = new HashSet<>();
        num = new HashSet<>();
    }

    public void add(int number) {
        if (num.contains(number)) {
            sum.add(number * 2);
        } else {
            for (int n : num) {
                sum.add(n + number);
            }
            num.add(number);
        }
    }

    public boolean find(int value) {
        return sum.contains(value);
    }

}
