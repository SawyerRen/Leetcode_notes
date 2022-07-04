package frequency.q200;

import java.util.Stack;

public class Q232 {
    class MyQueue {
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }
}
