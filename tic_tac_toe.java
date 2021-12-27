import java.io.ObjectInputFilter.Status;
import java.util.*;
import java.util.regex.Pattern;

public class tic_tac_toe {

    public static void main(String[] args) {

        char[][] board = {
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
        };

        gameIntro();

        Scanner scanner = new Scanner(System.in);
        found: {
            for (int i = 0; i < 9; i++) {
                System.out.println("Here is the current board - ");
                printBoard(board);
                int user;

                if (i % 2 == 0) {
                    user = 1;
                    System.out.println("-------User One-----");
                } else {
                    user = 2;
                    System.out.println("-------User Two-----");
                }

                System.out.println("Enter a number between 1-9 not already occupied - ");
                String userInput = scanner.nextLine();
                board = updateBoard(board, user, userInput);
                String status = winner(board);

                // System.out.println(status);

                if (status == "X") {
                    System.out.println("Winner is the X");
                    break;
                } else if (status == "O") {
                    System.out.println("Winner is the O");
                    break;
                }
            }
        }

        System.out.println("Match is draw");
    }

    public static void gameIntro() {
        System.out.println(
                "This game can be played using two players.\nFirst player's sign is \'x\'.\nSecond player's sign is \'o\'.");
        System.out.println(
                "Player can denote the desired box usiing the number between 1-9. The number convention for the board are as follows.");

        char[][] boardConvention = {
                { '1', '|', '2', '|', '3' },
                { '-', '+', '-', '+', '-' },
                { '4', '|', '5', '|', '6' },
                { '-', '+', '-', '+', '-' },
                { '7', '|', '8', '|', '9' },
        };
        printBoard(boardConvention);

        System.out.println("No more intro. Lets start the game!. \n\n");
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(row);
        }
    }

    public static char[][] updateBoard(char[][] board, int user, String userInput) {
        int input = Integer.parseInt(userInput);
        // System.out.println(userInput + " " + input);
        int row, column;
        row = ((input - 1) / 3) * 2;
        column = ((input - 1) % 3) * 2;

        // System.out.println(Arrays.deepToString(board));
        if (user == 1) {
            board[row][column] = (char) ('X');
        } else {
            board[row][column] = (char) ('O');
        }

        // System.out.println(Arrays.deepToString(board));

        return board;
    }

    // generating the patterns and return the winner or continue playing
    public static String winner(char[][] board) {
        String[][] boardNumbers = new String[3][3];
        String status = "play";

        for (int j = 0; j < 9; j++) {
            int row, column;
            row = (j / 3) * 2;
            column = (j % 3) * 2;
            // System.out.println(row + " " + column);
            boardNumbers[j / 3][j % 3] = String.valueOf(board[row][column]);
        }

        // System.out.println(Arrays.deepToString(board));
        // System.out.println(Arrays.deepToString(boardNumbers));

        String[][] patterns = new String[][] {
                { boardNumbers[0][0], boardNumbers[0][1], boardNumbers[0][2] }, // horizontal line number 1
                { boardNumbers[1][0], boardNumbers[1][1], boardNumbers[1][2] }, // horizontal line number 2
                { boardNumbers[2][0], boardNumbers[2][1], boardNumbers[2][2] }, // horizontal line number 3
                { boardNumbers[0][0], boardNumbers[1][0], boardNumbers[2][0] }, // vertical line number 1
                { boardNumbers[0][1], boardNumbers[1][1], boardNumbers[2][1] }, // vertical line number 2
                { boardNumbers[0][2], boardNumbers[1][2], boardNumbers[2][2] }, // vertical line number 3
                { boardNumbers[0][0], boardNumbers[1][1], boardNumbers[2][2] }, // diagonal line 1
                { boardNumbers[0][2], boardNumbers[1][1], boardNumbers[2][0] } // diagonal line 2
        };

        // System.out.println(Arrays.deepToString(patterns));

        for (String[] row : patterns) {
            status = checkPattern(row);
            if (status == "X" || status == "O") {
                break;
            }
        }

        return status;
    }

    // check the 3x1 patterns comes from winner method whther we have a winner or we
    // need to continue playing
    public static String checkPattern(String[] pattern) {
        int number_X = 0;
        int number_O = 0;
        // System.out.println(Arrays.toString(pattern));

        for (String i : pattern) {
            // System.out.println(i);
            if (i.equals("X")) {
                // System.out.println("ANe manda");
                number_X += 1;
            } else if (i.equals("O")) {
                number_O += 1;
            }
        }

        // System.out.println(number_O + " " + number_X);
        if (number_X == 3) {
            return "X";
        } else if (number_O == 3) {
            return "O";
        } else {
            return "play";
        }

    }

    public static void printWinner(String winStatus) {
        if (winStatus == "X") {
            System.out.println("User A won the match");
        } else if (winStatus == "O") {
            System.out.println("User B won the match");
        }
    }
}
