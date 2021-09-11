package all_solution.q100;

import java.util.Stack;

public class Q155 {

}

class MinStack {
    Stack<Integer> valStack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        valStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        valStack.pop();
        minStack.pop();
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}