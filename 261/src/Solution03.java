import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/31/16.
 */
public class Solution03 {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(-1, 0, visited, adjList)) {
            return false;
        }
        for (int v: visited) {
            if (v == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int pred, int vertex, int[] visited, List<List<Integer>> adjList) {
        visited[vertex] = 1;
        for (Integer succ: adjList.get(vertex)) {
            if (succ != pred) {
                if (visited[succ] == 1) {return true;}
                else if (visited[succ] == 0) {
                    if (hasCycle(vertex, succ, visited, adjList)) {return true;}
                }
            }
        }
        visited[vertex] = 2;
        return false;
    }
}
