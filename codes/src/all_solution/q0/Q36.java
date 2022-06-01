package all_solution.q0;

import java.util.HashSet;
import java.util.Set;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }
            set.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) return false;
            }
            set.clear();
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k++) {
                    int r = i + k / 3, c = j + k % 3;
                    if (board[r][c] != '.' && !set.add(board[r][c])) return false;
                }
                set.clear();
            }
        }
        return true;
    }
}
