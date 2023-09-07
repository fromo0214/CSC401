package Assignment_1.NKings;
import java.util.Random;

public class NQueens {
    //declaring final variables
    static final int N = 4;
    static final int MAX_ITERATIONS = 1000;


    public static void main(String[] args) {
        Queen[] queens = initializeQueens();
        double temperature = 1.0;
        double coolingRate = 0.003;

        for (int i = 0; i < MAX_ITERATIONS && queens.length != 0; i++) {
            Queen randomQueen = queens[new Random().nextInt(queens.length)];
            int currentConflicts = randomQueen.calculateConflicts(queens);
            
            int newRow = randomQueen.row + (new Random().nextInt(3) - 1); // Move the queen by -1, 0, or 1 rows
            int newCol = randomQueen.col + (new Random().nextInt(3) - 1); // Move the queen by -1, 0, or 1 columns
            
            // Make sure the new position is valid
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && (newRow != randomQueen.row || newCol != randomQueen.col)) {
                Queen newQueen = new Queen(newRow, newCol);
                int newConflicts = newQueen.calculateConflicts(queens);

                int deltaE = newConflicts - currentConflicts;
                if (deltaE < 0 || Math.random() < Math.exp(-deltaE / temperature)) {
                    queens[randomQueenIndex(queens)] = newQueen;
                }
            }

            temperature *= 1 - coolingRate;
        }

        if (queens.length == N) {
            printBoard(queens);
        } else {
            System.out.println("Solution not found.");
        }
    }

    // Initialize N queens randomly on the board
    private static Queen[] initializeQueens() {
        Queen[] queens = new Queen[N];
        for (int i = 0; i < N; i++) {
            queens[i] = new Queen(i, new Random().nextInt(N));
        }
        return queens;
    }

    // Find a random index in the range [0, N - 1]
    private static int randomQueenIndex(Queen[] queens) {
        return new Random().nextInt(queens.length);
    }

    // Print the N-Queens board
    private static void printBoard(Queen[] queens) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }
        for (Queen queen : queens) {
            board[queen.row][queen.col] = 'Q';
        }
        for (int i = 0; i < N; i++) {
            System.out.println(new String(board[i]));
        }
    }
}
