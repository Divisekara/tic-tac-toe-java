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

        for (int i = 0; i < 9; i++) {
            int user;
            if (i % 2 == 0) {
                user = 1;
            } else {
                user = 2;
            }
            System.out.println("-------User One-----");
            System.out.println("Here is the current board - ");
            printBoard(board);

            System.out.println("Enter a number between 1-9 not already occupied - ");
            String userInput = scanner.nextLine();
            updateBoard(board, user, userInput);
        }

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

    public static void updateBoard(char[][] board, int user, String userInput) {
        int input = Integer.parseInt(userInput);
        int row, column;
        row = ((input - 1) / 3) * 2;
        column = ((input - 1) % 3) * 2;

        if (user == 1) {
            board[row][column] = (char) ('X' + '0');
        } else {
            board[row][column] = (char) ('O' + '0');
        }
    }

    public static void winner(char[][] board) {
        String[][] boardNumbers = new String[3][3];

        for (int j = 1; j < 10; j++) {
            int row, column;
            row = (j / 3) * 2;
            column = (j % 3) * 2;
            boardNumbers[row][column] = String.valueOf(board[row][column]);
        }

        String status; // use to check the status of the winning and drawing
        String[] pattern = new String[3];

        for (int k = 0; k < 3; k++) {
            pattern = boardNumbers[k];
            String winStatus = checkPattern(pattern);

            if (winStatus == "X") {
                status = "User A won the match";
                break;
            } else if (winStatus == "O") {
                status = "User B won the match";
                break;
            }

            for (int j = 0; j < 3; j++) {
                pattern[j] = boardNumbers[j][k];
            }

            winStatus = checkPattern(pattern);

            if (winStatus == "X") {
                status = "User A won the match";
                break;
            } else if (winStatus == "O") {
                status = "User B won the match";
                break;
            }

        }

        String diagonal_1_1 = boardNumbers[0][0];
        String diagonal_1_2 = boardNumbers[1][1];
        String diagonal_1_3 = boardNumbers[2][2];

        pattern = new String[] { diagonal_1_1, diagonal_1_2, diagonal_1_3 };

    }

    // check the 3x1 patterns whther we have a winner or we need to continue playing
    public static String checkPattern(String[] pattern) {
        int number_X = 0;
        int number_O = 0;
        for (String i : pattern) {
            if (i == "X") {
                number_X += 1;
            } else {
                number_O += 1;
            }
        }

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
