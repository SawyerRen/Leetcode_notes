package company.fbr5.q400;

import java.util.HashSet;
import java.util.Set;

public class Q489 {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot, 0, 0, visited, 0);
    }

    private void helper(Robot robot, int row, int col, Set<String> visited, int d) {
        visited.add(row + "," + col);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int x = row + dirs[newD][0], y = col + dirs[newD][1];
            if (!visited.contains(x + "," + y) && robot.move()) {
                visited.add(x + "," + y);
                helper(robot, x, y, visited, newD);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();;
        }
    }
}
