package all_solution.q100;

import java.util.Map;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                res = Math.max(res, price - minPrice);
            }
        }
        return res;
    }
}
