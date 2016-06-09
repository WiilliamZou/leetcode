import java.util.*;

/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution03 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket: tickets) {
            if (!targets.containsKey(ticket[0])) {
                targets.put(ticket[0], new PriorityQueue<>());
            }
            targets.get(ticket[0]).add(ticket[1]);
        }
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while(targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
