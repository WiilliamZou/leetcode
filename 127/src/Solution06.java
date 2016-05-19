import java.util.*;

/**
 * Created by yunxiaozou on 5/18/16.
 */
public class Solution06 {
    List<List<String>> result;
    List<String> curr;
    Map<String, List<String>> adjacent;
    public int ladderLength(String start, String end, Set<String> dict) {
        result = new ArrayList<>();
        if(dict.size() == 0)
            return 0;
        boolean found = false;
        curr = new LinkedList<>();
        adjacent = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        int count = 1;

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
                            if (newWord.equals(end)) {
                                found = true;
                                return count;
                            }
                        }
                    }
                }
            }
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();
        }
        return 0;
    }

    private void backTrace(String word, String start, int count) {
        if (word.equals(start)) {
            curr.add(0, word);
            result.add(new ArrayList<>(curr));
            curr.remove(0);
            return;
        } else if (count == 0) {
            return;
        } else {
            curr.add(0, word);
            if (adjacent.get(word) != null) {
                for (String s : adjacent.get(word))
                    backTrace(s, start, count-1);
            }
            curr.remove(0);
        }
    }
}
