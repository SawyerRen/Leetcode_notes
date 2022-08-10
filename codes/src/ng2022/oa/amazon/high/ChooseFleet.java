package ng2022.oa.amazon.high;

public class ChooseFleet {
    int[] chooseFleets(int[] wheels) {
        int[] ans = new int[wheels.length];
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] % 2 != 0) {
                ans[i] = 0;
            } else {
                ans[i] = wheels[i] / 4 + 1;
            }
        }
        return ans;
    }
}
