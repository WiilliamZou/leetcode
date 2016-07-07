import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/19/16.
 */
public class Solution4 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            processNode(queue.remove(), map, queue);
        }
        return map.get(node);
    }

    private void processNode(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map, Queue<UndirectedGraphNode> queue) {
        if (!map.containsKey(node))
            map.put(node, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (map.containsKey(neighbor)) {
                map.get(node).neighbors.add(map.get(neighbor));
            } else {
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                map.get(node).neighbors.add(map.get(neighbor));
                queue.add(neighbor);
            }
        }
    }

}
