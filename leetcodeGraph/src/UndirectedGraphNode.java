import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/19/16.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
