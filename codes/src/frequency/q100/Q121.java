package frequency.q100;

public class Q121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            res = Math.max(res, price - min);
        }
        return res;
    }
}
