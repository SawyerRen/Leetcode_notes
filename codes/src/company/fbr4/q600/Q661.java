package company.fbr4.q600;

public class Q661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int x = i + k, y = j + l;
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        sum += img[x][y];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
