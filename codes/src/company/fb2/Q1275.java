package company.fb2;

public class Q1275 {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diagonal = 0, antiDiagonal = 0;
        int val = 1;
        for (int[] move : moves) {
            rows[move[0]] += val;
            cols[move[1]] += val;
            if (move[0] == move[1]) diagonal += val;
            if (move[0] == n - 1 - move[1]) antiDiagonal += val;
            if (Math.abs(rows[move[0]]) == n || Math.abs(cols[move[1]]) == n ||
                    Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
                return val == 1 ? "A" : "B";
            }
            val *= -1;
        }
        return moves.length < 9 ? "Pending" : "Draw";
    }
}
