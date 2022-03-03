package frequency.q100;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            }
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}
