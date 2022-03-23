package all_solution.q900;

import java.util.Random;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left < right) {
            int pivotIndex = helper(points, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        int[][] res = new int[k][2];
        if (k >= 0) System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private int helper(int[][] points, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(points, left, randomIndex);
        int pivot = cal(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && cal(points[j]) >= pivot) j--;
            while (i < j && cal(points[i]) <= pivot) i++;
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, left, i);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] p = points[i];
        points[i] = points[j];
        points[j] = p;
    }

    int cal(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
