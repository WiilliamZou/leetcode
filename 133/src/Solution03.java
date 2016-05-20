import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/19/16.
 */
public class Solution03 {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.remove();
            for (UndirectedGraphNode neighbor: curr.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(curr).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    map.get(curr).neighbors.add(neighborCopy);
                    queue.add(neighbor);
                }
            }
        }
        return nodeCopy;
    }

}
