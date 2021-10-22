package company.facebook;

public class Q622 {
}

class MyCircularQueue {
    int[] nums;
    int start;
    int end;
    int length;

    public MyCircularQueue(int k) {
        nums = new int[k];
        start = 0;
        end = -1;
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        end = (end + 1) % nums.length;
        nums[end] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        start = (start + 1) % nums.length;
        length--;
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
        return length == 0;
    }

    public boolean isFull() {
        return length == nums.length;
    }
}