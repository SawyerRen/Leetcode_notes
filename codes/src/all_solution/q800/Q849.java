package all_solution.q800;

import java.util.ArrayList;
import java.util.List;

public class Q849 {
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int left = i, right = i;
                while (i + 1 < seats.length && seats[i + 1] == 0) {
                    right = i + 1;
                    i++;
                }
                if (left == 0 || right == seats.length - 1) {
                    maxDist = Math.max(maxDist, right - left + 1);
                } else {
                    maxDist = Math.max(maxDist, (right - left + 2) / 2);
                }
            }
        }
        return maxDist;
    }
}
