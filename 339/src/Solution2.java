import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yunxiaozou on 6/9/16.
 */
public class Solution2 {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }

        int sum = 0;
        int level = 1;

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();

                if(ni.isInteger()){
                    sum += ni.getInteger() * level;
                }else{
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }

        return sum;
    }
}
