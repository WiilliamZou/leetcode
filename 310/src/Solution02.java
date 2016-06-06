import java.util.*;

/**
 * Created by yunxiaozou on 6/6/16.
 */
public class Solution02 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>(); //leaves likes queue.
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i); //in degree is 1.
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i: leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i); //这条路已经遍历过了
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
