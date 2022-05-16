package all_solution.q1800;

public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[] count = new int[101];
        for (int[] log : logs) {
            int start = log[0], end = log[1];
            for (int i = start; i < end; i++) {
                count[i - 1950]++;
            }
        }
        int maxIndex = 0, maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1950;
    }
}
