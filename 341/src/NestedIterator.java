import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> deque = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        Collections.reverse(nestedList);
        for (NestedInteger item: nestedList) {
            deque.addFirst(item);
        }

    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return deque.removeFirst().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            if (deque.peekFirst().isInteger()) return true;
            NestedInteger firstElement = deque.removeFirst();
            List<NestedInteger> list = firstElement.getList();
            Collections.reverse(list);
            for (NestedInteger item: list)
                deque.addFirst(item);
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */