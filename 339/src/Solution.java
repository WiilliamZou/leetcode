import java.util.List;

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
public class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger item: nestedList) {
            traverse(item, 1);
        }
        return sum;
    }

    private void traverse(NestedInteger item, int depth) {
        if (item.isInteger()) {
            sum += item.getInteger() * depth;
        } else {
            for (NestedInteger innerItem : item.getList()) {
                traverse(innerItem, depth+1);
            }
        }
    }
}