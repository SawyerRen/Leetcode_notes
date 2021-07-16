package topics.dfs;

public class Q302 {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minArea(char[][] image, int x, int y) {
        dfs(image, x, y);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        if (x < 0 || x > image.length || y < 0 || y >= image[0].length || image[x][y] == '0') return;
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        image[x][y] = '0';
        for (int[] dir : dirs) {
            dfs(image, x + dir[0], y + dir[1]);
        }
    }
}
