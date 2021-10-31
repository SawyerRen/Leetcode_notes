package company.facebook;

public class Q42 {
    public int trap(int[] height) {
        int res = 0;
        int leftMax = 0, rightMax = 0;
        int i = 0, j = height.length - 1;
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

    public int trap1(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
