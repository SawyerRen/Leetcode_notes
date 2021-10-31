package company.fbr3;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0;
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
            if (count[task - 'A'] > max) {
                max = count[task - 'A'];
                maxCount = 1;
            } else if (count[task - 'A'] == max) {
                maxCount++;
            }
        }
        int partCount = max - 1;
        int partLength = n + 1 - maxCount;
        int remainTasks = tasks.length - max * maxCount;
        int idle = partCount * partLength - remainTasks;
        if (idle <= 0) return tasks.length;
        return tasks.length + idle;
    }
}
