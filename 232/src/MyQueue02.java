import java.util.Stack;

/**
 * Created by yunxiaozou on 5/29/16.
 */
public class MyQueue02 {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }



}
