package all_solution.q900;

import java.util.Stack;

public class Q907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        long res = 0;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            res = (res + (long) arr[i] * left[i] * right[i]) % mod;
        }
        return (int) res;
    }
}
