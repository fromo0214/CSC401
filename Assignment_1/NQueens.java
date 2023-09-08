//I used chatGPT to help me print the board as I used a list instead of a 2D matrix i usually use to print the board

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class NQueens {
    static int n = 4;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                board[i][k] = '.';
            }
        }
        recur(0, board, res);
        return res;
    }

    // Reorganizes the board
    public static void recur(int column, char[][] board, List<List<String>> res) {
        if (column == board.length) {
            res.add(convert(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, column, board)) {
                board[row][column] = 'Q';
                recur(column + 1, board, res);
                board[row][column] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board) {
        int copy_row = row;
        int copy_col = col;

        // left upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = copy_row;
        col = copy_col;

        // leftwards
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = copy_row;
        col = copy_col;

        // left downwards diagonal
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    //Convers a list to string
    public static List<String> convert(char[][] board) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }

    // Prints the board
    public static void printBoard(List<String> board) {
        for (String row : board) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Printing all possible solutions...");
        for (List<String> solution : solutions) {
            printBoard(solution);
            System.out.println();
        }
    }
}