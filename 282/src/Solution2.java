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

        // what does this parameters means? for example: eval, multed...
        // path 是加入了运算符的string, 但是num 是原始的 num 的string, 这样貌似。。。
        if(pos == num.length()){
            if(target == eval) //这是题目的含义。
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break; // why this line? 01233432 is not allowed. here .
            // "105" is not for 1 * 05 like this... maybe like this...
            // the only number starts with 0 is 0. this is the explanation.
            long cur = Long.parseLong(num.substring(pos, i + 1)); // cur number? [pos, i] this range.
            // 解析出来的current number。
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
                // path + cur , concatenate? that is the explanation?
                // when i is 0, path is empty. that is the explanation.
                // when the pos is 0, no pre operand.
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}