package company.fb2;

import java.util.HashSet;
import java.util.Set;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) return false;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] != '.') {
                        if (!set.add(board[i + k / 3][j + k % 3])) return false;
                    }
                }
            }
        }
        return true;
    }
}
