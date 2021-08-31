package topics.math;

public class Q357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n < 0 || n > 10) return 0;
        int res = 10;
        int uniqueNums = 9;
        int availableNums = 9;
        while (n > 1 && availableNums > 0) {
            uniqueNums = uniqueNums * availableNums;
            res += uniqueNums;
            n--;
            availableNums--;
        }
        return res;
    }
}
