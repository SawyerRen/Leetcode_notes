package company.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int pivotIndex = helper(points, left, right);
            if (pivotIndex == k) break;
            if (pivotIndex < k) left = pivotIndex + 1;
            else right = pivotIndex - 1;
        }
        return Arrays.copyOf(points, k);
    }

    private int helper(int[][] points, int left, int right) {
        int index = new Random().nextInt(right - left + 1) + left;
        swap(points, left, index);
        int pivot = calDist(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && calDist(points[j]) >= pivot) j--;
            while (i < j && calDist(points[i]) <= pivot) i++;
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, left, i);
        return i;
    }

    private int calDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] t = points[i];
        points[i] = points[j];
        points[j] = t;
    }
}
