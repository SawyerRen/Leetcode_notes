package company.ffff;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Q973 {
    public int[][] kClosest1(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left < right) {
            int pivotIndex = helper(points, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int helper(int[][] points, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(points, left, randomIndex);
        int pivot = calculate(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && calculate(points[j]) >= pivot) j--;
            while (i < j && calculate(points[i]) <= pivot) i++;
            if (i < j) swap(points, i, j);
        }
        swap(points, left, i);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] p = points[i];
        points[i] = points[j];
        points[j] = p;
    }

    int calculate(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
