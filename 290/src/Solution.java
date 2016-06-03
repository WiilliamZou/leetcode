import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (charMap.containsKey(c) && !charMap.get(c).equals(word))
                return false;
            if (wordMap.containsKey(word) && wordMap.get(word) != c)
                return false;
            if (!charMap.containsKey(c)) {
                charMap.put(c, word);
                wordMap.put(word, c);
            }
        }
        return true;
    }
}