package topics.dp;

public class Q265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int min1 = 0, min2 = 0;
        int lastColor = -1;
        for (int[] cost : costs) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curColor = -1;
            for (int i = 0; i < cost.length; i++) {
                int curCost = i == lastColor ? cost[i] + min2 : cost[i] + min1;
                if (curCost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = curCost;
                    curColor = i;
                } else if (curCost < curMin2) {
                    curMin2 = curCost;
                }
            }
            min1 = curMin1;
            min2 = curMin2;
            lastColor = curColor;
        }
        return min1;
    }
}
