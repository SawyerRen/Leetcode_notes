package all_solution.q2100;

public class Q2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0, right = 100_000_000_000_000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            for (int val : time) {
                count += mid / val;
            }
            if (count >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
