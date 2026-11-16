class Solution {
    private List<List<String>> result = new ArrayList<>();
    private int[] queens; // queens[row] = col
    private int cols = 0;
    private int diag1 = 0; // row - col + (n - 1)
    private int diag2 = 0; // row + col

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result.add(constructBoard(n));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1);
            int d2 = row + col;

            // Check if column or either diagonal is under attack
            if ((cols & (1 << col)) != 0 || 
                (diag1 & (1 << d1)) != 0 || 
                (diag2 & (1 << d2)) != 0) {
                continue;
            }

            // Place queen
            queens[row] = col;
            cols |= (1 << col);
            diag1 |= (1 << d1);
            diag2 |= (1 << d2);

            backtrack(row + 1, n);

            // Backtrack (remove queen)
            cols &= ~(1 << col);
            diag1 &= ~(1 << d1);
            diag2 &= ~(1 << d2);
        }
    }

    private List<String> constructBoard(int n) {
        List<String> board = new ArrayList<>();
        char[] rowChars = new char[n];
        Arrays.fill(rowChars, '.');

        for (int r = 0; r < n; r++) {
            rowChars[queens[r]] = 'Q';
            board.add(new String(rowChars));
            rowChars[queens[r]] = '.'; // Reset for the next row
        }
        return board;
    }
}
