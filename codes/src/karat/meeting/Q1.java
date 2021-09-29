package karat.meeting;

public class Q1 {
    public static boolean canSchedule(int[][] meetings, int start, int end) {
        for (int[] meeting : meetings) {
            if (start < meeting[1] && end > meeting[1]) return false;
        }
        return true;
    }
}
