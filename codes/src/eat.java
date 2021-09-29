import java.util.*;

public class eat {
    public static void main(String[] args) {

    }

    void searchWord(List<String> list, char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (String word : list) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (search(word, board, i, j, dirs)) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }
        }
    }

    private boolean search(String word, char[][] board, int i, int j, int[][] dirs) {
        for (int[] dir : dirs) {
            int index = 0;
            while (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                if (index == word.length()) return true;
                if (word.charAt(0) != board[i][j]) break;
                index++;
                i += dir[0];
                j += dir[1];
            }
        }
        return false;
    }
}
