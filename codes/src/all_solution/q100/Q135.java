package all_solution.q100;

import java.util.Arrays;

public class Q135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
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
