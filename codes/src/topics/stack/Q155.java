package topics.stack;

public class Q155 {
}

class MinStack {
    MinNode head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new MinNode(val, val, null);
        } else {
            head = new MinNode(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class MinNode {
    int val;
    int min;
    MinNode next;

    public MinNode() {
    }

    public MinNode(int val, int min, MinNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}