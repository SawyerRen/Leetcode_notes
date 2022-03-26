package all_solution.q1000;

public class Q1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, d = 0;
        for (char c : instructions.toCharArray()) {
            switch (c) {
                case 'L' -> d = (d + 3) % 4;
                case 'R' -> d = (d + 1) % 4;
                case 'G' -> {
                    row += dirs[d][0];
                    col += dirs[d][1];
                }
            }
        }
        return (row == 0 && col == 0) || d != 0;
    }
}
