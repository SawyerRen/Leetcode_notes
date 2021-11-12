package company.fbr4.q600;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0;
        int[] count = new int[26];
        for (char task : tasks) {
            int i = task - 'A';
            count[i]++;
            if (count[i] > max) {
                max = count[i];
                maxCount = 1;
            } else if (count[i] == max) {
                maxCount++;
            }
        }
        int partCount = max - 1;
        int partLen = n + 1 - maxCount;
        int remainTask = tasks.length - max * maxCount;
        int idle = partCount * partLen - remainTask;
        if (idle <= 0) return tasks.length;
        return tasks.length + idle;
    }
}
