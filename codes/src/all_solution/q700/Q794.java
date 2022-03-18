package all_solution.q700;

public class Q794 {
    public boolean validTicTacToe(String[] board) {
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }
        int countX = count(gameBoard, 'X');
        int countO = count(gameBoard, 'O');
        if (countO > countX || countX > countO + 1) return false;
        boolean winX = win(gameBoard, 'X');
        boolean winO = win(gameBoard, 'O');
        if (winO && winX) return false;
        if (winO && countX != countO) return false;
        if (winX && countO == countX) return false;
        return true;
    }

    private boolean win(char[][] board, char x) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == x && board[i][1] == x && board[i][2] == x) return true;
            if (board[0][i] == x && board[1][i] == x && board[2][i] == x) return true;
        }
        if (board[0][0] == x && board[1][1] == x && board[2][2] == x) return true;
        if (board[0][2] == x && board[1][1] == x && board[2][0] == x) return true;
        return false;
    }

    private int count(char[][] board, char x) {
        int count = 0;
        for (char[] row : board) {
            for (char c : row) {
                if (c == x) count++;
            }
        }
        return count;
    }
}
