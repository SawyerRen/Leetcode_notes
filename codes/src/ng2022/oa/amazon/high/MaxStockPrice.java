package ng2022.oa.amazon.high;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxStockPrice {
    static int maxStockPrice(int[] price, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        int res = -1;
        int sum = 0;
        while (j < price.length) {
            while (set.contains(price[j])) {
                set.remove(price[i]);
                sum -= price[i++];
            }
            set.add(price[j]);
            sum += price[j++];
            if (set.size() == k) res = Math.max(res, sum);
        }
        return res;
    }

    static int maxStockPrice1(int[] price, int k) {
        int left = -1, kSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < price.length; i++) {
            if (map.containsKey(price[i]) && map.get(price[i]) > left) {
                left = map.get(price[i]);
            }
            map.put(price[i], i);
            kSum += price[i];
            if (i - k >= 0) {
                kSum -= price[i - k];
            }
            if (i - k >= left) {
                res = Math.max(res, kSum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxStockPrice(new int[]{1, 2, 7, 7, 4, 3, 6}, 3));
        System.out.println(maxStockPrice(new int[]{1, 2, 3, 4}, 2));
    }
}
