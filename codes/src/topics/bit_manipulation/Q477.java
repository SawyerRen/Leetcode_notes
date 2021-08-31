package topics.bit_manipulation;

public class Q477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int total = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) count++;
            }
            res += (total - count) * count;
        }
        return res;
    }
}
