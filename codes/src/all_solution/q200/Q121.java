package all_solution.q200;

import java.util.Map;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }
        return res;
    }
}
