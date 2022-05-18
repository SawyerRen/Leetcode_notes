package all_solution.q1800;

public class Q1861 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = box[m - 1 - j][i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == '#') {
                    int row = i;
                    while (row + 1 < n && res[row + 1][j] == '.') row++;
                    if (row != i) {
                        res[row][j] = '#';
                        res[i][j] = '.';
                    }
                }
            }
        }
        return res;
    }
}
