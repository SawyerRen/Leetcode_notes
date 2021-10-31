package company.facebook;

import java.awt.*;
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
    Set<String> visited = new HashSet<>();
    Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        helper(0, 0, 0);
    }

    private void helper(int row, int col, int d) {
        visited.add(row + "," + col);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int nextRow = row + dirs[newD][0], nextCol = col + dirs[newD][1];
            if (!visited.contains(nextRow + "," + nextCol) && robot.move()) {
                helper(nextRow, nextCol, newD);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
