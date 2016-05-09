/**
 * Created by yunxiaozou on 5/9/16.
 */
public class Solution3 {
    public boolean isNumber(String s) {
        return s.matches("^\\s*[\\+\\-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[\\+\\-]?[0-9]+)?\\s*$");
    }
}
