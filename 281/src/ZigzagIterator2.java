import java.util.Iterator;
import java.util.List;

/**
 * Created by yunxiaozou on 6/2/16.
 */
public class ZigzagIterator2 {
    private Iterator<Integer> i, j, temp;

    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) { temp = j; j = i; i = temp; }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
