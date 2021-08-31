package all_solution;

public class Q42 {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int leftMax = height[0], rightMax = height[n - 1];
        int left = 0, right = n - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMax = new int[n];
//        int[] rightMax = new int[n];
//        leftMax[0] = height[0];
//        rightMax[n - 1] = height[n - 1];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//        int res = 0;
//        for (int i = 1; i < n - 1; i++) {
//            res += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return res;
//    }
}
