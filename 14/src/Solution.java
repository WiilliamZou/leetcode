/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int i = 0;
        while (true) {
            if (strs[0].length() <= i) {
                if (i > 0) {
                    return strs[0].substring(0, i);
                }else {
                    return "";
                }
            }

            char current = strs[0].charAt(i);
            for(String str : strs) {
                if (str.length() <= i || str.charAt(i) != current) {
                    if (i > 0) {
                        return strs[0].substring(0, i);
                    }else {
                        return "";
                    }
                }
            }
            i++;
        }

    }
}