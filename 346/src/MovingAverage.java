import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    double count = 0.0;
    double average = 0.0;
    Queue<Integer> queue = new LinkedList<>();
    double size = 0.0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (count < size) {
            queue.add(val);
            average = (average * count + val) / (count + 1);
            count++;
        }else {
            average = (average * count + val - queue.remove()) / count;
            queue.add(val);
        }
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */