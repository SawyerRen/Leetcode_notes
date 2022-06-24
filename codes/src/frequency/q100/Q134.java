package frequency.q100;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i : gas) {
            totalGas += i;
        }
        for (int i : cost) {
            totalCost += i;
        }
        if (totalGas < totalCost) return -1;
        int curGas = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                curGas = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
