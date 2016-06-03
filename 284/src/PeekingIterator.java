import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer temp = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (temp != null) return temp;
        if (!iterator.hasNext()) return null;
        temp = iterator.next();
        return temp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (temp != null) {
            Integer result = temp;
            temp = null;
            return result;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (temp != null) {
            return true;
        } else {
            return iterator.hasNext();
        }
    }
}