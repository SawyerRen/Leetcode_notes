package all_solution.q100;

import java.util.HashSet;
import java.util.Set;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (char c : row) {
                if (c != '.' && set.contains(c)) return false;
                set.add(c);
            }
        }
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.' && set.contains(c)) return false;
                set.add(c);
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    char c = board[i + k / 3][j + k % 3];
                    if (c != '.' && set.contains(c)) return false;
                    set.add(c);
                }
            }
        }
        return true;
    }
}
