package all_solution.q0;

public class Q11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0, area = 0;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
