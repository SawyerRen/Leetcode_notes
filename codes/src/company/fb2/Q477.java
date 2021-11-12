package company.fb2;

public class Q477 {
    public int totalHammingDistance(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) count[i]++;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += count[i] * (nums.length - count[i]);
        }
        return res;
    }
}
