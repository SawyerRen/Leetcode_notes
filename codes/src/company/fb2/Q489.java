package company.fb2;

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

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }

    private void helper(Robot robot, int i, int j, int d, Set<String> visited) {
        visited.add(i + "," + j);
        robot.clean();
        for (int k = 0; k < 4; k++) {
            int newD = (d + k) % 4;
            int x = i + dirs[newD][0], y = j + dirs[newD][1];
            if (!visited.contains(x + "," + y) && robot.move()) {
                helper(robot, x, y, newD, visited);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
