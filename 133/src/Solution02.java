import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunxiaozou on 5/19/16.
 */
public class Solution02 {
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
