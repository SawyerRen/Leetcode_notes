package company.fbr4.q300;

public class Q348 {
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
            cols[col] += val;
            if (row == col) diagonal += val;
            if (row == n - 1 - col) antiDiagonal += val;
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) return player;
            return 0;
        }
    }
}
