package Assignment_1;
import java.util.ArrayList;
import java.util.List;

public class NQueens401 {

    private int n;
    private List<List<Integer>> board;

    public NQueens401(int n) {
        this.n = n;
        this.board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                board.get(i).add(0);
            }
        }
    }

    public boolean solve() {
        return solve(0);
    }

    private boolean solve(int col) {
        if (col == n) {
            return true; // All queens are placed successfully.
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                board.get(row).set(col, 1); // Place queen
                if (solve(col + 1)) {
                    return true; // Recur to place the rest of the queens
                }
                board.get(row).set(col, 0); // If placing queen at (row, col) doesn't lead to a solution, backtrack
            }
        }
        return false; // No solution found for this column
    }

    private boolean isSafe(int row, int col) {
        // Check for queens in the same row
        for (int i = 0; i < col; i++) {
            if (board.get(row).get(i) == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j) == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board.get(i).get(j) == 1) {
                return false;
            }
        }

        return true;
    }

    public void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Change this to the desired board size
        NQueens401 nQueens = new NQueens401(n);
        if (nQueens.solve()) {
            System.out.println("Solution exists:");
            nQueens.printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }
}