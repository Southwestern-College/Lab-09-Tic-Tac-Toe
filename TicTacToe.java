import java.util.Scanner;

/**
 * A simplified tic-tac-toe game used to practice two-dimensional arrays.
 *
 * @author Your Name
 */
public class TicTacToe {

    public static final int SIZE = 3;
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = ' ';

    public static void initializeBoard(char[][] board) {
        // TODO: Fill every position with EMPTY.
    }

    public static void printBoard(char[][] board) {
        // TODO: Print the board in a readable format.
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        // TODO: Return true if row and col are on the board
        // and the selected square is empty.
        return false;
    }

    public static void makeMove(char[][] board, int row, int col, char player) {
        // TODO: Place the player's mark on the board.
    }

    public static boolean hasWon(char[][] board, char player) {
        // TODO: Check all rows, columns, and diagonals.
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        // TODO: Return true if there are no empty squares.
        return false;
    }

    public static char switchPlayer(char currentPlayer) {
        if (currentPlayer == X) {
            return O;
        }
        return X;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[][] board = new char[SIZE][SIZE];
        char currentPlayer = X;

        initializeBoard(board);

        while (!hasWon(board, currentPlayer) && !isBoardFull(board)) {
            printBoard(board);

            System.out.println("Player " + currentPlayer + ", enter row:");
            int row = input.nextInt();

            System.out.println("Player " + currentPlayer + ", enter column:");
            int col = input.nextInt();

            if (isValidMove(board, row, col)) {
                makeMove(board, row, col, currentPlayer);

                if (!hasWon(board, currentPlayer)) {
                    currentPlayer = switchPlayer(currentPlayer);
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard(board);

        if (hasWon(board, currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("Tie game!");
        }

        input.close();
    }
}
