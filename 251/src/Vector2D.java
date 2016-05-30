import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    private Iterator<Integer> innerIterator;
    private Iterator<List<Integer>> outerIterator;
    public Vector2D(List<List<Integer>> vec2d) {
        outerIterator = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return innerIterator.next();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while ((innerIterator == null || !innerIterator.hasNext()) &&
                outerIterator.hasNext()) {
            innerIterator  = outerIterator.next().iterator();
        }
        return innerIterator != null && innerIterator.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */