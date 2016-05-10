import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String res = "";
        Set<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }

        for (String dir : stack) {
            res = "/" + dir + res;
        }
        if (res.isEmpty())
            res = "/";
        return res;
    }
}