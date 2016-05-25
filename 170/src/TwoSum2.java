import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/25/16.
 */
public class TwoSum2 {
    Set<Integer> sum;
    Set<Integer> num;

    public TwoSum2(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(num.contains(number)){
            //computed before.
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return sum.contains(value);
    }
}