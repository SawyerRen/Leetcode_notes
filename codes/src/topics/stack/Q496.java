package topics.stack;

import java.util.*;

public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[nums2.length];
        Arrays.fill(temp, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                temp[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(nums2[i], temp[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
