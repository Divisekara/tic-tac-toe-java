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
        printBoard(board);

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

        System.out.println("No more intro. Lets start the game!.");
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(row);
        }
    }

}