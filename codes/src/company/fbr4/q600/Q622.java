package company.fbr4.q600;

public class Q622 {
    class MyCircularQueue {
        int[] nums;
        int start;
        int end;
        int size;

        public MyCircularQueue(int k) {
            nums = new int[k];
            size = 0;
            end = -1;
            start = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            end = (end + 1) % nums.length;
            nums[end] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            start = (start + 1) % nums.length;
            size--;
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
            return size == 0;
        }

        public boolean isFull() {
            return size == nums.length;
        }
    }
}
