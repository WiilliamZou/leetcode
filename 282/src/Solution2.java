import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path,
                       String num, int target, int pos,
                       long eval, long multed){


        if(pos == num.length()){
            if(target == eval) //这是题目的含义。
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            // when the start is '0'. only 0
            long cur = Long.parseLong(num.substring(pos, i + 1)); // current number generated in this dfs step
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);// when pos == 0, path is empty string.
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                // when +-, eval is result, the first operand is reset.
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
                // when *, we need to reset the previous computation...
            }
        }
    }
}