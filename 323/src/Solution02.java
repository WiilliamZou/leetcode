/**
 * Created by yunxiaozou on 6/7/16.
 */
public class Solution02 {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            size[i] = 1;
        }
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if (root1 != root2) {
                if (size[root1] > size[root2]) {
                    roots[root2] = root1;
                    size[root1] += size[root2];
                }else {
                    roots[root1] = root2;
                    size[root2] += size[root1];
                }
                n--;
            }
        }
        return n;
    }
    public int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
