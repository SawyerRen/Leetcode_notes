package company.fbr5.q700;

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
        if (winO && countX > countO) return false;
        if (winX && countX == countO) return false;
        return true;
    }

    private boolean win(char[][] gameBoard, char c) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == c && gameBoard[i][1] == c && gameBoard[i][2] == c) return true;
            if (gameBoard[0][i] == c && gameBoard[1][i] == c && gameBoard[2][i] == c) return true;
        }
        if (gameBoard[0][0] == c && gameBoard[1][1] == c && gameBoard[2][2] == c) return true;
        if (gameBoard[0][2] == c && gameBoard[1][1] == c && gameBoard[2][0] == c) return true;
        return false;
    }

    private int count(char[][] gameBoard, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == c) count++;
            }
        }
        return count;
    }
}
