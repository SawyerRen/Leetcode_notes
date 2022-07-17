package ng2022.q600;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int maxCount = 0, max = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (count[task - 'A'] > max) {
                maxCount = 1;
                max = count[task - 'A'];
            } else if (count[task - 'A'] == max) {
                maxCount++;
            }
        }
        int partCount = max - 1;
        int partLength = n + 1 - maxCount;
        int remainTask = tasks.length - max * maxCount;
        int idle = partCount * partLength - remainTask;
        if (idle <= 0) return tasks.length;
        return tasks.length + idle;
    }
}
