package company.facebook;

public class Q622 {
}

class MyCircularQueue {
    int[] nums;
    int start, end, len;

    public MyCircularQueue(int k) {
        nums = new int[k];
        start = 0;
        end = -1;
        len = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        end = (end + 1) % nums.length;
        nums[end] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        start = (start + 1) % nums.length;
        len--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return nums[start];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return nums[end];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == nums.length;
    }
}