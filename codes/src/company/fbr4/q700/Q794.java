package company.fbr4.q700;

public class Q794 {
    public boolean validTicTacToe(String[] s) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = s[i].charAt(j);
            }
        }
        int countX = count(board, 'X');
        int countO = count(board, 'O');
        if (countO > countX || countX > countO + 1) return false;
        boolean winX = win(board, 'X');
        boolean winO = win(board, 'O');
        if (winO && winX) return false;
        if (winO && countX > countO) return false;
        if (winX && countO == countX) return false;
        return true;
    }

    private boolean win(char[][] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
        return false;
    }

    private int count(char[][] board, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c == board[i][j]) count++;
            }
        }
        return count;
    }
}
