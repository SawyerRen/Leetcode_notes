package company.facebook;

import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
