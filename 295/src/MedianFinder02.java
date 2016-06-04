import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder02 {
    private Queue<Integer> small = new PriorityQueue<>((a,b) -> b - a);
    private Queue<Integer> large = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.remove());
        if (large.size() < small.size()) {
            large.add(small.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (large.size() > small.size()) ?
                large.peek()
                : large.peek() + (small.peek() - large.peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();