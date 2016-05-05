import java.util.*;

/**
 * Created by yunxiaozou on 5/4/16.
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:
 For the return value, each inner list's elements must follow the lexicographic order.
 All inputs will be in lower-case.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String newS = String.valueOf(sArray);
            if (!map.containsKey(newS)) {
                map.put(newS, new ArrayList<>());
            }
            map.get(newS).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> l : map.values()) {
            Collections.sort(l);
            result.add(l);
        }
        return result;
    }
}