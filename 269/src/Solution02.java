import java.util.*;

/**
 * Created by yunxiaozou on 6/1/16.
 */
public class Solution02 {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        String ans = null;
        Set<Character> charSet = new HashSet<>();
        buildGraph(words, adjList, charSet);
        ans = toposortDFS(adjList, charSet);
        return ans;
    }

    private Set<Character> getCharSet(String[] words, Set<Character> charSet) {
        for (String word: words) {
            for (char c: word.toCharArray()) {
                charSet.add(c);
            }
        }
        return charSet;
    }

    private String toposortDFS(Map<Character, List<Character>> adjList, Set<Character> charSet) {
        StringBuilder ans = new StringBuilder();
        int[] visited = new int[26];


        for (char v: adjList.keySet()) {
            if (visited[v-'a'] == 0) {
                if (!visitDFS(ans, adjList, visited, v)) {
                    return "";
                }
            }
        }
        for (char c: charSet) {
            ans.insert(0, c);
        }
        return ans.reverse().toString();
    }

    private boolean visitDFS(StringBuilder ans, Map<Character, List<Character>> adjList, int[] visited, char node) {
        if (visited[node-'a'] == 1)
            return false;
        if (visited[node-'a'] == 0) {
            visited[node-'a'] = 1;
            if (adjList.get(node) != null) {
                for (char m : adjList.get(node)) {
                    if (!visitDFS(ans, adjList, visited, m))
                        return false;
                }
            }
            visited[node-'a'] = 2;
            ans.append(node);
        }
        return true;
    }

    private void buildGraph(String[] words, Map<Character, List<Character>> adjList, Set<Character> charSet) {
        getCharSet(words, charSet);
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                for (int k = 0; k < Math.min(words[i].length(), words[j].length()); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        charSet.remove(words[i].charAt(k));
                        charSet.remove(words[j].charAt(k));

                        if (adjList.containsKey(words[i].charAt(k))) {
                            List<Character> list = adjList.get(words[i].charAt(k));
                            if (!list.contains(words[j].charAt(k))) {
                                list.add(words[j].charAt(k));
                            }
                        }
                        else {
                            List<Character> newList = new ArrayList<>();
                            newList.add(words[j].charAt(k));
                            adjList.put(words[i].charAt(k), newList);
                        }
                        break;
                    }
                }
            }
        }
    }
}
