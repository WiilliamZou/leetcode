/**
 * Created by yunxiaozou on 4/13/16.
 * seems two pointers.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || words[0].length() == 0) return new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> list = new ArrayList<>();
        int gap = words[0].length();
        int nlen = words.length * gap;
        for (int k = 0; k < gap; k++) {
            HashMap<String, Integer> wordmap = new HashMap<>(map);
            for (int i = k, j = 0; i + j <= s.length() - gap; ) {
                String temp = s.substring(i + j, i + j + gap);
                if (wordmap.containsKey(temp)) {
                    wordmap.put(temp, wordmap.get(temp) - 1);
                    if (wordmap.get(temp) == 0) wordmap.remove(temp);
                    if (wordmap.isEmpty()) list.add(i);
                    j += gap;
                } else {
                    if (j == 0) i += gap;
                    else {
                        wordmap.put(s.substring(i, i + gap), wordmap.getOrDefault(s.substring(i, i + gap), 0) + 1);
                        i += gap;
                        j -= gap;
                    }
                }
            }
        }
        return list;
    }
}