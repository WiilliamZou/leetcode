import java.util.*;

/**
 * Created by yunxiaozou on 5/10/16.
 */
public class Solution3 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        //for (String dir : stack) res = "/" + dir + res;
        for (String dir: stack) res += "/" + dir;
        return res.isEmpty() ? "/" : res;
    }
}
