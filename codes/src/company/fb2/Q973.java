package company.fb2;

import java.util.PriorityQueue;
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
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int helper(int[][] points, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(points, left, pivotIndex);
        int pivot = calculate(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && pivot <= calculate(points[j])) j--;
            while (i < j && pivot >= calculate(points[i])) i++;
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

    public int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> calculate(b) - calculate(a));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    int calculate(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
