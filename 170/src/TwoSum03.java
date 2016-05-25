import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class TwoSum03 {

    Map<Integer, Integer> hm;

    public TwoSum03() { hm = new HashMap<>();}

    public void add(int number) {
        if (hm.containsKey(number)) {
            hm.put(number, 2);
        } else {
            hm.put(number,1);
        }
    }

    public boolean find(int value) {
        for (int num1 : hm.keySet()) {
            int num2 = value - num1;
            if (hm.containsKey(num2)) {
                if (num1 != num2 || hm.get(num2) == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
