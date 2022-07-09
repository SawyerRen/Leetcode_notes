package ng2022.q100;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0, minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}
