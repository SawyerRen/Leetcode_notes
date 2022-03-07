package all_solution.q300;

public class Q348 {
}

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antDiagonal;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) diagonal += val;
        if (row == n - col - 1) antDiagonal += val;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n || Math.abs(antDiagonal) == n) return player;
        return 0;
    }
}