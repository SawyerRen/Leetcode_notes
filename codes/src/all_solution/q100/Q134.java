package all_solution.q100;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i : gas) {
            totalGas += i;
        }
        for (int i : cost) {
            totalCost += i;
        }
        if (totalCost > totalGas) return -1;
        int start = 0;
        int curGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }
        return start;
    }
}
