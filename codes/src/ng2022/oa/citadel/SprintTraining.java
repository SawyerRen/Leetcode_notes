package ng2022.oa.citadel;

import java.util.Map;

public class SprintTraining {
    public static int getModifiedArray(int length, int[] sprints) {
        int[] res = new int[length + 2];
        for (int i = 0; i < sprints.length - 1; i++) {
            int start = Math.min(sprints[i], sprints[i + 1]);
            int end = Math.max(sprints[i], sprints[i + 1]);
            res[start] += 1;
            res[end + 1] -= 1;
        }
        int max = 0;
        for (int val : res) {
            max = Math.max(val, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getModifiedArray(5, new int[]{2, 4, 1, 3}));
    }
}
