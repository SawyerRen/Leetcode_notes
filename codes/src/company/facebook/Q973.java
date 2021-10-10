package company.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int pivotIndex = partition(points, left, right);
            if (pivotIndex == k) break;
            if (pivotIndex < k) left = pivotIndex + 1;
            else right = pivotIndex - 1;
        }
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int index = new Random().nextInt(right - left + 1) + left;
        swap(points, left, index);
        int pivot = compute(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && compute(points[j]) >= pivot) {
                j--;
            }
            while (i < j && compute(points[i]) <= pivot) {
                i++;
            }
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, left, i);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

    private int compute(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distB - distA;
        });
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}
