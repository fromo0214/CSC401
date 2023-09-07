import java.util.Arrays;
import java.util.Random;

public class NQueensHillClimbing {

    public static void main(String[] args) {
        int n = 4; // Change this to the desired board size
        int[] solution = solveNQueens(n);
        printBoard(solution);
    }

    public static int[] solveNQueens(int n) {
        int[] board = new int[n];
        initializeRandomBoard(board);

        int maxSteps = 1000; // Maximum number of iterations
        int steps = 0;

        while (steps < maxSteps && calculateConflicts(board) > 0) {
            int[] nextBoard = Arrays.copyOf(board, n);
            int minConflicts = Integer.MAX_VALUE;
            int row = 0;

            for (int i = 0; i < n; i++) {
                int originalCol = board[i];
                for (int j = 0; j < n; j++) {
                    if (j != originalCol) {
                        nextBoard[i] = j;
                        int conflicts = calculateConflicts(nextBoard);
                        if (conflicts < minConflicts) {
                            minConflicts = conflicts;
                            row = i;
                        }
                    }
                }
                nextBoard[i] = originalCol;
            }

            board[row] = nextBoard[row];
            steps++;
        }

        return board;
    }

    public static int calculateConflicts(int[] board) {
        int conflicts = 0;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (board[i] == board[j] || Math.abs(i - j) == Math.abs(board[i] - board[j])) {
                    conflicts++;
                }
            }
        }

        return conflicts;
    }

    public static void initializeRandomBoard(int[] board) {
        Random random = new Random();
        for (int i = 0; i < board.length; i++) {
            board[i] = random.nextInt(board.length);
        }
    }

    public static void printBoard(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i] == j ? "Q " : ".  ");
            }
            System.out.println();
        }
    }
}