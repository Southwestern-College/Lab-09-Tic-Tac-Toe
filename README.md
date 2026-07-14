# Lab 09: Two-Dimensional Arrays

## Objectives

- Create and use a two-dimensional array.
- Practice nested loop traversal using rows and columns.
- Write static methods that process a 2D array.
- Use conditionals to validate and update array elements.
- Represent a simple game board using a 2D array.

## Program Description

In this lab, you will create part of a simplified tic-tac-toe game.

A tic-tac-toe board can be represented as a two-dimensional array of characters. Each location in the array represents one square on the board.

Each square will contain one of the following values:

| Character | Meaning |
|-----------|---------|
| `'X'` | Player X |
| `'O'` | Player O |
| `' '` | Empty square |

The game uses a 3 by 3 board.

Most of the game loop has been provided for you. Your job is to complete the methods that work directly with the two-dimensional array.

## Program Specifications

Complete the `TicTacToe` class by implementing the following static methods.

You should complete the methods in the order listed below. Some methods rely on earlier methods.

### Part 1: Create the Board

Before the game can begin, every square on the board must be initialized.

| Return Type | Method | Description |
|--------------|---------|-------------|
| `void` | `initializeBoard(char[][] board)` | Fills every position in the board with the empty character. |

Use nested `for` loops to visit every row and column.

After this method is called, every square in the board should be empty.

---

### Part 2: Display the Board

Once the board has values, the program needs to display it.

| Return Type | Method | Description |
|--------------|---------|-------------|
| `void` | `printBoard(char[][] board)` | Displays the board in a readable tic-tac-toe format. |

A printed board might look like this:

```text
 X | O | X
---+---+---
 O | X |  
---+---+---
   |   | O
```

This method should not change the board. It should only print the board.

---

### Part 3: Validate and Make Moves

Before placing a mark on the board, the program should check whether the move is valid.

| Return Type | Method | Description |
|--------------|---------|-------------|
| `boolean` | `isValidMove(char[][] board, int row, int col)` | Returns `true` if the row and column are on the board and the selected square is empty. |
| `void` | `makeMove(char[][] board, int row, int col, char player)` | Places the player's character at the selected row and column. |

A move is valid only when both of the following are true:

1. The row and column are inside the board.
2. The selected square is empty.

For this lab, `makeMove` does not need to check whether the move is valid. The main method will call `isValidMove` before calling `makeMove`.

---

### Part 4: Check for a Tie

A tie happens when the board is full and no player has won.

| Return Type | Method | Description |
|--------------|---------|-------------|
| `boolean` | `isBoardFull(char[][] board)` | Returns `true` if there are no empty squares left on the board. |

Use nested `for` loops to search the board.

If you find at least one empty square, the board is not full.

---

### Part 5: Check for a Winner

A player wins tic-tac-toe by getting three marks in a row.

| Return Type | Method | Description |
|--------------|---------|-------------|
| `boolean` | `hasWon(char[][] board, char player)` | Returns `true` if the player has three marks in any row, column, or diagonal. |

Your method must check:

- all three rows
- all three columns
- the diagonal from top-left to bottom-right
- the diagonal from top-right to bottom-left

This is the most challenging method in the lab. Complete the earlier parts first.

---

### Part 6: Run the Game

The `main` method has already been provided.

After you complete the required methods, run the program and play a full game.

## Notes

- Use a 3 by 3 `char` array to represent the board.
- Use nested `for` loops when processing the whole board.
- Array indexes start at `0`.
- Valid row and column values are `0`, `1`, and `2`.
- You may assume the user enters integers when prompted for row and column.
- You should not create separate variables for every square on the board.
- Do not use nine separate variables such as `topLeft`, `topMiddle`, or `bottomRight`.
- Focus on using the 2D array to store, update, and check the game board.

## Sample Test

Save the following tester as `TestTicTacToe.java`.

```java
public class TestTicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        TicTacToe.initializeBoard(board);

        System.out.println("Initial board:");
        TicTacToe.printBoard(board);

        System.out.println("Move at row 0, column 0 is valid: "
                + TicTacToe.isValidMove(board, 0, 0)); // true

        TicTacToe.makeMove(board, 0, 0, 'X');
        TicTacToe.makeMove(board, 0, 1, 'X');
        TicTacToe.makeMove(board, 0, 2, 'X');

        System.out.println("\nBoard after moves:");
        TicTacToe.printBoard(board);

        System.out.println("Player X won: "
                + TicTacToe.hasWon(board, 'X')); // true

        System.out.println("Move at row 0, column 0 is valid: "
                + TicTacToe.isValidMove(board, 0, 0)); // false

        System.out.println("Board is full: "
                + TicTacToe.isBoardFull(board)); // false
    }
}
```

## Coding Standards

- Use meaningful identifiers and follow Java naming conventions.
- Remove all auto-generated comments and unused code.
- Document code using [JavaDoc](https://www.baeldung.com/javadoc), including:
  - Program/class description
  - Attribution using the `@author` tag.
- Comment only when necessary.
- Format code cleanly and consistently:
  - Proper indentation
  - Brace alignment
  - Whitespace for readability
- Ensure prompts and output are clear and properly formatted.

## Extension (Optional)

If you finish early, try adding one of these:

- Ask players whether they want to play again.
- Keep track of how many games each player has won.
- Allow the user to choose whether Player X or Player O goes first.
- Create a simple computer player that chooses the first available empty square.
- Print row and column labels to make the board easier to use.