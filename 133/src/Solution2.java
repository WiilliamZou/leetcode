/**
 * Created by yunxiaozou on 5/19/16.
 */
public class Solution2 {
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    // DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for (UndirectedGraphNode n : node.neighbors)
            copy.neighbors.add(cloneGraph(n));
        return copy;
    }

    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode neigh : cur.neighbors) {
                if (map.containsKey(neigh)) map.get(cur).neighbors.add(map.get(neigh));
                else {
                    UndirectedGraphNode neighCopy = new UndirectedGraphNode(neigh.label);
                    map.put(neigh, neighCopy);
                    map.get(cur).neighbors.add(neighCopy);
                    q.add(neigh);
                }
            }
        }
        return copy;
    }
}
