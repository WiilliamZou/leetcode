import java.util.*;

/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution02 {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket: tickets) {
            if (!targets.containsKey(ticket[0])) {
                targets.put(ticket[0], new PriorityQueue<>());
            }
            targets.get(ticket[0]).add(ticket[1]);
        }
        visit("JFK");
        return route;
    }
    private void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll());
        }
        route.add(0, airport);
    }
}
