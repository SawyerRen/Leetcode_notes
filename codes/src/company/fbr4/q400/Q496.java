package company.fbr4.q400;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                map.put(nums2[index], nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
