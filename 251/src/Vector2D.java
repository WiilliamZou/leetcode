import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    private Iterator<Integer> innerIterator;
    private Iterator<List<Integer>> outerIterator;
    public Vector2D(List<List<Integer>> vec2d) {
        outerIterator = vec2d.iterator();
        innerIterator = null;
    }

    @Override
    public Integer next() {
    }

    @Override
    public boolean hasNext() {
        return
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */