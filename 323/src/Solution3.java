import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for (int start = 0; start < n; start++) {
            if (!visited[start]) {
                dfs(start, visited, adj);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;
        for (int next: adj[node]) {
            if (!visited[next]) {
                dfs(next, visited, adj);
            }
        }
    }
}