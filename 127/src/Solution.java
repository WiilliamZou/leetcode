import java.util.*;

/**
 * Created by yunxiaozou on 5/18/16.
 */
public class Solution {
    List<List<String>> result;

    Map<String, List<String>> adjacent;
    public int ladderLength(String start, String end, Set<String> dict) {
        result = new ArrayList<>();
        if(dict.size() == 0)
            return 0;
        boolean found = false;
        adjacent = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.remove();
                //build adjacent neighbors
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder builder = new StringBuilder(word);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        builder.setCharAt(j, ch);
                        String newWord = builder.toString();
                        if (unvisited.contains(newWord)) {
                            if (visited.add(newWord)) {
                                queue.add(newWord);
                            }
                            if (adjacent.containsKey(newWord))
                                adjacent.get(newWord).add(word);
                            else {
                                List<String> l = new LinkedList<>();
                                l.add(word);
                                adjacent.put(newWord, l);
                            }
                            if (newWord.equals(end)) found = true;
                        }
                    }
                }
            }
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();
        }
        return count;
    }


}
