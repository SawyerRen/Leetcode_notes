package all_solution.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q225 {
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if (empty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (empty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}