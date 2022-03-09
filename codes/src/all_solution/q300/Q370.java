package all_solution.q300;

public class Q370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], value = update[2];
            res[start] += value;
            if (end + 1 < res.length) {
                res[end + 1] -= value;
            }
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
