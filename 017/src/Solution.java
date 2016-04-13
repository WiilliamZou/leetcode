import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    HashMap<Integer, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuffer buffer = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(digits, 0, buffer);
        return result;
    }
    private void dfs(String digits, int index, StringBuffer buffer) {
        if (index == digits.length()) {
            result.add(buffer.toString());
            return;
        }
        char c = digits.charAt(index);
        if (!Character.isDigit(c) || c == '1' || c == '0')
            throw new IllegalArgumentException();
        String choices = map.get(c-'0');
        for (int i = 0; i < choices.length(); i++) {
            buffer.append(choices.charAt(i));
            dfs(digits, index+1, buffer);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
}