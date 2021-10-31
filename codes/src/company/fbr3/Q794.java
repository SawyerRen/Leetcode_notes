package company.fbr3;

public class Q794 {
    public boolean validTicTacToe(String[] board) {
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }
        int countX = count(gameBoard, 'X');
        int countO = count(gameBoard, 'O');
        if (countO > countX || countO + 1 < countX) return false;
        boolean winX = win(gameBoard, 'X');
        boolean winO = win(gameBoard, 'O');
        if (winO && winX) return false;
        if (winX && countO == countX) return false;
        if (winO && countO < countX) return false;
        return true;
    }

    private boolean win(char[][] gameBoard, char x) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == x && gameBoard[i][1] == x && gameBoard[i][2] == x) return true;
            if (gameBoard[0][i] == x && gameBoard[1][i] == x && gameBoard[2][i] == x) return true;
        }
        if (gameBoard[0][0] == x && gameBoard[1][1] == x && gameBoard[2][2] == x) return true;
        if (gameBoard[2][0] == x && gameBoard[1][1] == x && gameBoard[0][2] == x) return true;
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
