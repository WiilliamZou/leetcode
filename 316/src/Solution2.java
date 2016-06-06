public class Solution2 {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        // cnt 代表每一个字母出现的次数。
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
            // 当s[i]是一个只出现一次的字母?
            // pos 之前的字符不予保留
        }
        return s.length() == 0 ? "" : s.charAt(pos) +
                removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}