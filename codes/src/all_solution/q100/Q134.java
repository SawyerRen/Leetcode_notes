package all_solution.q100;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for (int i : gas) {
            totalGas += i;
        }
        int totalCost = 0;
        for (int i : cost) {
            totalCost += i;
        }
        if (totalCost > totalGas) return -1;
        int curGas = 0;
        int start = 0;
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
