package all_solution.q300;

public class Q302 {
    int minX = 0, maxX = 0, minY = 0, maxY = 0;

    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        maxX = minX = x;
        minY = maxY = y;
        dfs(image, x, y, m, n);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(char[][] image, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != '1') return;
        image[i][j] = '0';
        maxX = Math.max(maxX, i);
        minX = Math.min(minX, i);
        maxY = Math.max(maxY, j);
        minY = Math.min(minY, j);
        for (int[] dir : dirs) {
            dfs(image, i + dir[0], j + dir[1], m, n);
        }
    }
}
