package company.facebook;

public class Q348 {
}

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        if (Math.abs(rows[row]) == n) return player;
        cols[col] += val;
        if (Math.abs(cols[col]) == n) return player;
        if (col == row) diagonal += val;
        if (Math.abs(diagonal) == n) return player;
        if (col == n - 1 - row) antiDiagonal += val;
        if (Math.abs(antiDiagonal) == n) return player;
        return 0;
    }
}