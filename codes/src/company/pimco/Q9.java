package company.pimco;

import java.util.*;

// IPO
public class Q9 {
    static List<Integer> solution(int[][] bids, int totalShare) {
        Map<Integer, Integer> userShareMap = new HashMap<>();
        Map<Integer, List<int[]>> priceBidMap = new HashMap<>();
        List<Integer> prices = new ArrayList<>();
        for (int[] bid : bids) {
            userShareMap.put(bid[0], bid[1]);
            priceBidMap.putIfAbsent(bid[2], new ArrayList<>());
            priceBidMap.get(bid[2]).add(bid);
            prices.add(bid[2]);
        }
        // sort bids by timestamp
        for (Integer price : priceBidMap.keySet()) {
            List<int[]> bidsList = priceBidMap.get(price);
            bidsList.sort(Comparator.comparingInt(a -> a[3]));
        }
        // sort prices reversely
        prices.sort(Comparator.reverseOrder());
        for (Integer price : prices) {
            if (totalShare == 0) break;
            List<int[]> bidsList = priceBidMap.get(price);
            if (bidsList.size() == 1) {
                int[] bid = bidsList.get(0);
                int allot = Math.min(bid[1], totalShare);
                totalShare -= allot;
                bid[1] -= allot;
            } else {
                int size = bidsList.size();
                while (totalShare > 0 && size > 0) {
                    for (int[] bid : bidsList) {
                        if (totalShare == 0) break;
                        if (bid[1] == 0) continue;
                        bid[1] -= 1;
                        totalShare -= 1;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] bid : bids) {
            if (bid[1] == userShareMap.get(bid[0])) {
                res.add(bid[0]);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] bids = {{1, 2, 5, 0}, {2, 1, 4, 2}, {3, 5, 4, 6}};
        int totalShare = 3;
        System.out.println(solution(bids, totalShare));
    }
}
