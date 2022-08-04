package ng2022.oa.imc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2 {
    static class MyStack {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> incr = new HashMap<>();
        int curSum = 0;

        void push(int val) {
            curSum += val;
            stack.push(val);
            incr.put(stack.size(), 0);
        }

        int pop() {
            if (stack.isEmpty()) return -1;
            if (incr.size() > 1) {
                incr.put(stack.size() - 1, incr.get(stack.size() - 1) + incr.get(stack.size()));
            }
            int val = incr.get(stack.size()) + stack.pop();
            incr.remove(stack.size() + 1);
            curSum -= val;
            return val;
        }

        int inc(int i, int val) {
            if (incr.size() > 1) {
                int size = Math.min(i, stack.size());
                incr.put(size, incr.get(size) + val);
            }
            curSum += i * val;
            return stack.peek() + incr.get(stack.size());
        }

        boolean empty() {
            return stack.size() == 0;
        }

        int peek() {
            if (stack.isEmpty()) return -1;
            return stack.peek() + incr.get(stack.size());
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
        stack.inc(2, 1);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
