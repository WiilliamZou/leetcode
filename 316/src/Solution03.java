import java.util.Stack;

/**
 * Created by yunxiaozou on 6/6/16.
 */
public class Solution03 {
    public String removeDuplicateLetters(String sr) {
        int[] res = new int[26];
        boolean[] visited = new boolean[26];
        char[] ch = sr.toCharArray();
        for (char c: ch) {
            res[c-'a']++;
        }
        Stack<Character> st = new Stack<>();
        int index;
        for (char s:ch) {
            index = s-'a';
            res[index]--;
            if(visited[index])
                continue;
            while (!st.isEmpty() && s < st.peek() && res[st.peek()-'a'] != 0) {
                visited[st.pop()-'a'] = false;
            }
            st.push(s);
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
