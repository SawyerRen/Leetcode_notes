package all_solution.q100;

import java.util.Arrays;

public class Q135 {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int[] candy = new int[ratings.length];
        // 先全分配一个candy
        Arrays.fill(candy, 1);
        // 从左边遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // 从右边遍历
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }
        int res = 0;
        for (int i : candy) {
            res += i;
        }
        return res;
    }
}
