package company.pimco;

//给一个int array 里面的数代表每个商品的价钱 有一个优惠办法是
// 从第二个商品开始 每个商品可以减去之前所有商品的原价里的最小值
// 最多可以减至免费 不会到负数 求照这样优惠最后会付多少钱
public class Q1 {
    int solution(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int res = prices[0];
        int preMin = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] > preMin) {
                res += prices[i] - preMin;
            } else {
                preMin = prices[i];
            }
        }
        return res;
    }
}
