package all_solution.q1300;

public class Q1381 {
    class CustomStack {
        int maxSize = 0;
        int size = 0;
        int[] arr;

        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (size == maxSize) return;
            arr[size++] = x;
        }

        public int pop() {
            if (size == 0) return -1;
            return arr[--size];
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i < size; i++) {
                arr[i] += val;
            }
        }
    }
}
