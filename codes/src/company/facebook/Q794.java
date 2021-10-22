package company.facebook;

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
        if (countX < countO || countX > countO + 1) return false;
        boolean winX = win(gameBoard, 'X');
        boolean winO = win(gameBoard, 'O');
        if (winX && winO) return false;
        if (winX && countX == countO) return false;
        if (winO && countX > countO) return false;
        return true;
    }

    private boolean win(char[][] gameBoard, char x) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == x && gameBoard[i][1] == x && gameBoard[i][2] == x) return true;
            if (gameBoard[0][i] == x && gameBoard[1][i] == x && gameBoard[2][i] == x) return true;
        }
        if (gameBoard[0][0] == x && gameBoard[1][1] == x && gameBoard[2][2] == x) return true;
        if (gameBoard[1][1] == x && gameBoard[2][0] == x && gameBoard[0][2] == x) return true;
        return false;
    }

    private int count(char[][] gameBoard, char x) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == x) count++;
            }
        }
        return count;
    }
}
