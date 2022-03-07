package all_solution.q300;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Q353 {
}

class SnakeGame {
    Set<Integer> set;
    LinkedList<Integer> queue;
    int width;
    int height;
    int foodIndex;
    int score;
    int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.food = food;
        set.add(0);
        queue.addLast(0);
    }

    public int move(String direction) {
        if (score == -1) return -1;

        int row = queue.peekFirst() / width;
        int col = queue.peekFirst() % width;
        switch (direction) {
            case "U" -> row--;
            case "D" -> row++;
            case "L" -> col--;
            case "R" -> col++;
        }
        Integer tail = queue.removeLast();
        set.remove(tail);
        if (row < 0 || row >= height || col < 0 || col >= width || set.contains(row * width + col)) {
            score = -1;
            return -1;
        }
        set.add(row * width + col);
        queue.addFirst(row * width + col);
        if (foodIndex < food.length && row == food[foodIndex][0] && col == food[foodIndex][1]) {
            foodIndex++;
            set.add(tail);
            queue.addLast(tail);
            score++;
            return score;
        }
        return score;
    }
}