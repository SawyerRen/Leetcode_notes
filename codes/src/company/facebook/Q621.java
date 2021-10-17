package company.facebook;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (max == count[task - 'A']) {
                maxCount++;
            }
            if (max < count[task - 'A']) {
                max = count[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n + 1 - maxCount;
        int availableTask = tasks.length - max * maxCount;
        int idles = Math.max(0, partCount * partLength - availableTask);
        return tasks.length + idles;
    }
}
