package topics.dp;

public class Q121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int res = 0;
        for (int price : prices) {
            res = Math.max(res, price - minPrice);
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return res;
    }
}
