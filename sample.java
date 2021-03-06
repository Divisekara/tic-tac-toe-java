import java.util.Arrays;

public class sample {
    public static void main(String[] args) {
        String[][] boardNumbers = {
                { "1", "2", "3" },
                { "4", "5", "6" },
                { "7", "8", "9" }
        };

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

        for (String[] row : patterns) {
            System.out.println(Arrays.toString(row));
        }

        // System.out.println(Arrays.deepToString(patterns));
    }
}