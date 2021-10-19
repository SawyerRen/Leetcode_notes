package company.facebook;

public class Q121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            res = Math.max(res, price - min);
        }
        return res;
    }
}
