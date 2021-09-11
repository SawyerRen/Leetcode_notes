package all_solution.q100;

public class Q137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >>> i) & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= (count % 3) << i;
            }
        }
        return res;
    }
}
