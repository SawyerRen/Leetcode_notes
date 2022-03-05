package frequency.q100;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) return -1;
        int start = 0, curGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i];
            curGas -= cost[i];
            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }
        return start;
    }
}
