package company.facebook;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q341 {
}

 class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        buildStack(nestedList);
    }

    private void buildStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            buildStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}