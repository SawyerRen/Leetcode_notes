package all_solution.q200;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q284 {

}

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            peek = iterator.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek == null) {
            return iterator.next();
        }
        int res = peek;
        peek = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return peek != null || iterator.hasNext();
    }
}
