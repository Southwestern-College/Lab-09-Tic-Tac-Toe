import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void initializeBoardFillsEverySquareWithEmptyCharacter() {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];

        TicTacToe.initializeBoard(board);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                assertEquals(TicTacToe.EMPTY, board[row][col]);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 2",
            "1, 1",
            "2, 0",
            "2, 2"
    })
    void emptySquaresOnTheBoardAreValidMoves(int row, int col) {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        assertTrue(TicTacToe.isValidMove(board, row, col));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "0, -1",
            "3, 0",
            "0, 3",
            "-1, -1",
            "3, 3"
    })
    void movesOutsideTheBoardAreInvalid(int row, int col) {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        assertFalse(TicTacToe.isValidMove(board, row, col));
    }

    @Test
    void occupiedSquareIsNotAValidMove() {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, 1, 1, 'X');

        assertFalse(TicTacToe.isValidMove(board, 1, 1));
    }

    @Test
    void makeMovePlacesPlayerMarkAtGivenLocation() {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, 2, 1, 'O');

        assertEquals('O', board[2][1]);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2"
    })
    void hasWonReturnsTrueForCompletedRow(int row) {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, row, 0, 'X');
        TicTacToe.makeMove(board, row, 1, 'X');
        TicTacToe.makeMove(board, row, 2, 'X');

        assertTrue(TicTacToe.hasWon(board, 'X'));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2"
    })
    void hasWonReturnsTrueForCompletedColumn(int col) {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, 0, col, 'O');
        TicTacToe.makeMove(board, 1, col, 'O');
        TicTacToe.makeMove(board, 2, col, 'O');

        assertTrue(TicTacToe.hasWon(board, 'O'));
    }

    @Test
    void hasWonReturnsTrueForMainDiagonal() {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, 0, 0, 'X');
        TicTacToe.makeMove(board, 1, 1, 'X');
        TicTacToe.makeMove(board, 2, 2, 'X');

        assertTrue(TicTacToe.hasWon(board, 'X'));
    }

    @Test
    void hasWonReturnsTrueForOtherDiagonal() {
        char[][] board = new char[TicTacToe.SIZE][TicTacToe.SIZE];
        TicTacToe.initializeBoard(board);

        TicTacToe.makeMove(board, 0, 2, 'O');
        TicTacToe.makeMove(board, 1, 1, 'O');
        TicTacToe.makeMove(board, 2, 0, 'O');

        assertTrue(TicTacToe.hasWon(board, 'O'));
    }

    @Test
    void hasWonReturnsFalseWhenPlayerDoesNotHaveThreeInARow() {
        char[][] board = charBoard(
                "XO ",
                "OX ",
                "  O"
        );

        assertFalse(TicTacToe.hasWon(board, 'X'));
    }

    @Test
    void isBoardFullReturnsFalseWhenAtLeastOneSquareIsEmpty() {
        char[][] board = charBoard(
                "XOX",
                "OXO",
                "XO "
        );

        assertFalse(TicTacToe.isBoardFull(board));
    }

    @Test
    void isBoardFullReturnsTrueWhenThereAreNoEmptySquares() {
        char[][] board = charBoard(
                "XOX",
                "OXO",
                "XOX"
        );

        assertTrue(TicTacToe.isBoardFull(board));
    }

    @Test
    void switchPlayerChangesXToO() {
        assertEquals('O', TicTacToe.switchPlayer('X'));
    }

    @Test
    void switchPlayerChangesOToX() {
        assertEquals('X', TicTacToe.switchPlayer('O'));
    }

    private static char[][] charBoard(String row0, String row1, String row2) {
        return new char[][]{
                row0.toCharArray(),
                row1.toCharArray(),
                row2.toCharArray()
        };
    }
}
