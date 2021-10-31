package company.facebook.freq;

import java.util.Map;

public class Q42 {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                res += leftMax - height[i];
                i++;
            } else {
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
