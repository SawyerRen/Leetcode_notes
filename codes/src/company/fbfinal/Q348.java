package company.fbfinal;

public class Q348 {
    class TicTacToe {
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;
        int size;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            diagonal = 0;
            antiDiagonal = 0;
            size = n;
        }

        public int move(int row, int col, int player) {
            int value = player == 1 ? 1 : -1;
            rows[row] += value;
            cols[col] += value;
            if (row == col) diagonal += value;
            if (row == size - 1 - col) antiDiagonal += value;
            if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size)
                return player;
            return 0;
        }
    }
}
