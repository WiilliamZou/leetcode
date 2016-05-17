import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        if (rowIndex == 0) {
            curr.add(1); return curr;
        } else if (rowIndex == 1) {
            curr.add(1); curr.add(1); return curr;
        } else {
            curr.add(1);
            long num = 1;
            for (int i = 0; i < rowIndex; i++){
                num *= (rowIndex-i);
                num /= (i+1);
                curr.add((int)num);
            }
            return curr;
        }
    }
}