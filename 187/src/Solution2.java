import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution2 {
    // 理解 set 的 处理
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        Set<String> resset = new HashSet<String>();
        if(s == null || s.length() <= 10){
            return res;
        }
        Set<String> set = new HashSet<String>();
        int len = s.length();
        for(int i = 0; i <= len - 10; i++){
            // sub is the string starting from index i.
            String sub = s.substring(i, i + 10);
            if(!set.add(sub)){
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }
}