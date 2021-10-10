package company.codesignal.quora;

public class FindOddZeroNumber {
    static int solution(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int zeroCount = 0;
            if (num == 0) {
                count++;
                continue;
            }
            while (num != 0) {
                if (num % 10 == 0) zeroCount++;
                num /= 10;
            }
            if (zeroCount % 2 != 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 100, 12902310, 320};
        System.out.println(solution(nums));
    }
}
