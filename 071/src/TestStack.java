import java.util.Stack;

/**
 * Created by yunxiaozou on 6/21/16.
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 10; i++)
            stack.push(i);
        for (int i: stack)
            System.out.println(i);
    }
}
