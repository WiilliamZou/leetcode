import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yunxiaozou on 5/31/16.
 */
public class Solution04 {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) { adjList.add(new ArrayList<>()); }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0); visited[0] = 1; // start point
        while (!q.isEmpty()) { // q contains the visiting node.
            Integer cur = q.removeFirst();
            for (Integer succ: adjList.get(cur)) {
                if (visited[succ] == 1) {return false;}
                if (visited[succ] == 0) {q.addLast(succ); visited[succ] = 1;}
            }
            visited[cur] = 2;
        }
        for (int v: visited) {if (v == 0) return false;}
        return true;
    }
}
