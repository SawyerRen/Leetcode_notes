package company.bytedance.interview;

public class Q20 {
    static void solution(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    int area = dfs(map, i, j);
                    setArea(map, i, j, area);
                }
            }
        }
    }

    private static void setArea(int[][] map, int i, int j, int area) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != 1) {
            return;
        }
        map[i][j] = area;
        for (int[] dir : dirs) {
            setArea(map, i + dir[0], j + dir[1], area);
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] map, int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != 1) {
            return 0;
        }
        map[i][j] = 2;
        int area = 1;
        for (int[] dir : dirs) {
            area += dfs(map, i + dir[0], j + dir[1]);
        }
        map[i][j] = 1;
        return area;
    }

    public static void main(String[] args) {
        int[][] map = {{0, 0, 0, 1}, {1, 1, 0, 1}, {1, 0, 0, 0}};
        solution(map);
        for (int[] row : map) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
