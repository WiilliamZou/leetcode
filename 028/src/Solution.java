/**
 * Created by yunxiaozou on 4/13/16.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length())
                return -1;
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}