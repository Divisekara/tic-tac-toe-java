import java.util.Arrays;

public class sample {
    public static void main(String[] args) {
        String[][] boardNumbers = {
                { "1", "2", "3" },
                { "4", "5", "6" },
                { "7", "8", "9" }
        };

        String[] pattern = new String[3];

        pattern = boardNumbers[2];
        System.out.println(Arrays.toString(pattern));

    }
}