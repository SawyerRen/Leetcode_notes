package topics.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // col
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // part
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k++) {
                    char c = board[i + k / 3][j + k % 3];
                    if (c != '.') {
                        if (set.contains(c)) return false;
                        set.add(c);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
