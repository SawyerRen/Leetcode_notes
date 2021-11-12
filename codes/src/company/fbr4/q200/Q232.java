package company.fbr4.q200;

import java.util.Stack;

public class Q232 {
    class MyQueue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
