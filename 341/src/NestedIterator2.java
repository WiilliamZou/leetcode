import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator2 implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator2(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger())
                return true;
            else {
                List<NestedInteger> list = top.getList();
                stack.pop();
                for (int i = list.size()-1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}