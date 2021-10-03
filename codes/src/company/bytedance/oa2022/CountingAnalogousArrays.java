package company.bytedance.oa2022;

public class CountingAnalogousArrays {
    static int countArrays(int[] difference, int lowerBound, int upperBound) {
        int highest = 0, lowest = 0, sum = 0;
        for (int i : difference) {
            sum += i;
            highest = Math.max(highest, sum);
            lowest = Math.min(lowest, sum);
        }
        int res = (upperBound - lowerBound + (lowest - highest + 1));
        if (res < 0) return -1;
        return res;
    }

    public static void main(String[] args) {

        System.out.println(countArrays(new int[]{-2, -1, -2, 5}, 3, 10));
    }
}
