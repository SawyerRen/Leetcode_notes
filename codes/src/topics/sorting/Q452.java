package topics.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        int count = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
