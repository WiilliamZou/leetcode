import java.util.Stack;

/**
 * Created by yunxiaozou on 5/22/16.
 */
public class MinStack4 {
    private Stack<Integer> st = new Stack<Integer>();
    private Stack<Integer> min_st = new Stack<Integer>();

    public void push(int x) {
        if(min_st.isEmpty() || min_st.peek()>=x) min_st.push(x);
        st.push(x);
    }

    public void pop() {
        if((int)st.peek()==(int)min_st.peek()) min_st.pop();
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min_st.peek();
    }
}