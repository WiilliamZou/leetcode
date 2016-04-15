import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunxiaozou on 4/13/16.
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words.length == 0 || words[0].length() == 0)
            return result;
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word,0)+1);
        }
        int gap = words[0].length();

        for (int start = 0; start < gap; start++) {
            HashMap<String, Integer> currentMap = new HashMap<>(wordMap);
            int left = start;
            int right = left;
            while (right + gap <= s.length()) {
                String currentWord  = s.substring(right, right + gap);
                if (currentMap.containsKey(currentWord)) {
                    right += gap;
                    currentMap.put(currentWord, currentMap.get(currentWord)-1);
                    if (currentMap.get(currentWord) == 0) {
                        currentMap.remove(currentWord);
                    }
                    if (currentMap.isEmpty()) {
                        result.add(left);
                    }
                } else {
                    if (left == right) {
                        left += gap;
                        right += gap;
                    } else {
                        String rollback = s.substring(left, left + gap);
                        currentMap.put(rollback, currentMap.getOrDefault(rollback, 0) + 1);
                        left += gap;
                    }
                }
            }
        }
        return result;
    }

}