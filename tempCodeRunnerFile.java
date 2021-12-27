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