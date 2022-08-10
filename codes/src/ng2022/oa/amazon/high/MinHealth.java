package ng2022.oa.amazon.high;

public class MinHealth {
    int findMinHealth(int[] power, int armor) {
        int max = power[0];
        int sum = 0;
        for (int i : power) {
            max = Math.max(max, i);
            sum += i;
        }
        if (armor >= max) return sum - max + 1;
        else return sum - armor + 1;
    }
}
