package company.facebook;

public class Q477 {
    public int totalHammingDistance(int[] nums) {
        int[] hash = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                hash[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += hash[i] * (nums.length - hash[i]);
        }
        return res;
    }
}
