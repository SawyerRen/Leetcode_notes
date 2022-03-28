package all_solution.q1100;

public class Q1151 {
    public int minSwaps(int[] data) {
        int countOnes = 0;
        for (int datum : data) {
            if (datum == 1) countOnes++;
        }
        int i = 0, j = 0, count = 0;
        while (j < countOnes) {
            if (data[j] == 1) count++;
            j++;
        }
        int res = countOnes - count;
        while (j < data.length) {
            if (data[j] == 1) count++;
            if (data[i] == 1) count--;
            res = Math.min(res, countOnes - count);
            i++;
            j++;
        }
        return res;
    }
}
