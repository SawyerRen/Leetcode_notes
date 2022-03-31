package all_solution.q1200;

public class Q1275 {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) board[moves[i][0]][moves[i][1]] = 'A';
            else board[moves[i][0]][moves[i][1]] = 'B';
        }
        if (win(board, 'A')) return "A";
        if (win(board, 'B')) return "B";
        return moves.length == 9 ? "Draw" : "Pending";
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
}
