package topics.greedy;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) return -1;
        int start = 0;
        int fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            fuel = fuel + gas[i] - cost[i];
            if (fuel < 0) {
                fuel = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
