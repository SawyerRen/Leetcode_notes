package topics.array;

public class Q495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int index = 0;
        for (int start : timeSeries) {
            index = Math.max(index, start);
            while (index < start + duration) {
                res++;
                index++;
            }
        }
        return res;
    }
}
