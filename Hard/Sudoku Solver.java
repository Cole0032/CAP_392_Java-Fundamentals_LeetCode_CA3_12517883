class Solution {
    private int[] rowMask = new int[9];
    private int[] colMask = new int[9];
    private int[] boxMask = new int[9];

    public void solveSudoku(char[][] board) {
        // Pre-populate masks with the existing numbers
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int d = board[r][c] - '1';
                    int box = (r / 3) * 3 + (c / 3);
                    rowMask[r] |= (1 << d);
                    colMask[c] |= (1 << d);
                    boxMask[box] |= (1 << d);
                }
            }
        }

        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        // Reached beyond the last row -> puzzle solved
        if (r == 9) {
            return true;
        }

        // Move to the next row when column exceeds bounds
        if (c == 9) {
            return backtrack(board, r + 1, 0);
        }

        // If current cell is already filled, skip to next cell
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }

        int box = (r / 3) * 3 + (c / 3);

        // Try placing digits '1' through '9'
        for (int d = 0; d < 9; d++) {
            int mask = 1 << d;
            // Check if digit d + 1 is already used in row, col, or box
            if ((rowMask[r] & mask) == 0 && (colMask[c] & mask) == 0 && (boxMask[box] & mask) == 0) {
                // Place digit
                board[r][c] = (char) ('1' + d);
                rowMask[r] |= mask;
                colMask[c] |= mask;
                boxMask[box] |= mask;

                if (backtrack(board, r, c + 1)) {
                    return true;
                }

                // Backtrack (undo move)
                board[r][c] = '.';
                rowMask[r] &= ~mask;
                colMask[c] &= ~mask;
                boxMask[box] &= ~mask;
            }
        }

        return false;
    }
}
