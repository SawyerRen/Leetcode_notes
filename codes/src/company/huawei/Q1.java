package company.huawei;

import java.util.Arrays;
import java.util.Stack;

public class Q1 {
    public static int[] solution(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {20, 30, 40, 30, 20, 10, 50, 40, 45};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
