import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class MyStack02 {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int size = q.size();
        for (int i = 0; i < size-1; i++) {
            q.add(q.remove());
        }
    }
    public void pop() {
        q.remove();
    }
    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }


}
