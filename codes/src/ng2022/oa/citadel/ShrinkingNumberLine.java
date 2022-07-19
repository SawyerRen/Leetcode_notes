package ng2022.oa.citadel;

public class ShrinkingNumberLine {
    public static int minimize(int[] point, int k) {
        if (point == null || point.length == 0) {
            return -1;
        }

        int incre = dfs(point, k, 1, point[0]+k, point[0]+k);
        int decre = dfs(point, k, 1, point[0]-k, point[0]-k);

        return Math.min(incre, decre);
    }

    public static int dfs(int[] point, int k, int idx, int min, int max) {
        if (idx >= point.length) {
            return max - min;
        }

        int min_incre = Math.min(min, point[idx] + k);
        int max_incre = Math.max(max, point[idx] + k);
        int incre = dfs(point, k, idx + 1, min_incre, max_incre);

        int min_decre = Math.min(min, point[idx] - k);
        int max_decre = Math.max(max, point[idx] - k);
        int decre = dfs(point, k, idx + 1, min_decre, max_decre);

        return Math.min(incre, decre);
    }
}
