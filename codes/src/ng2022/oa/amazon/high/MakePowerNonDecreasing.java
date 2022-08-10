package ng2022.oa.amazon.high;

public class MakePowerNonDecreasing {
    static int makePowerNonCreasing(int[] power) {
        int add = 0;
        int highest = power[0];
        for (int i = 1; i < power.length; i++) {
            if (power[i] + add < highest) {
                add += highest - (power[i] + add);
            }
            highest = Math.max(highest, power[i] + add);
        }
        return add;
    }

    public static void main(String[] args) {
        int[] power = {3, 4, 1, 6, 2};
        System.out.println(makePowerNonCreasing(power));
    }
}
