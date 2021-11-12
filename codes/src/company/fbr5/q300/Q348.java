package company.fbr5.q300;

public class Q348 {
    class TicTacToe {
        int[] rows;
        int[] cols;
        int diagonal, antiDiagonal;
        int size;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            diagonal = antiDiagonal = 0;
            size = n;
        }

        public int move(int row, int col, int player) {
            int val = player == 1 ? 1 : -1;
            rows[row] += val;
            cols[col] += val;
            if (row == col) diagonal += val;
            if (row == size - 1 - col) antiDiagonal += val;
            if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
                    Math.abs(antiDiagonal) == size || Math.abs(diagonal) == size) return player;
            return 0;
        }
    }
}
