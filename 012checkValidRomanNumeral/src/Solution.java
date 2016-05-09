import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yunxiaozou on 4/21/16.
 */
public class Solution {
    public boolean checkValidRomanNumeral(String input) {
        return input.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
