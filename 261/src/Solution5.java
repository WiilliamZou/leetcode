import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public boolean validTree(int n, int[][] edges) {
        List[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        if (!dfs(0, 0, visited, adj)) return false;

        for(int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private boolean dfs(int prev, int node, boolean[] visited, List<Integer>[] adj) {
        if (visited[node])
            return true;
        visited[node] = true;
        for (int next: adj[node]) {
            if (next != prev && visited[next])
                return false;
            if (!dfs(node, next, visited, adj))
                return false;
        }
        return true;
    }
}