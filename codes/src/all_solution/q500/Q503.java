package all_solution.q500;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n * 2; i++) {
            int index = i % n;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}
