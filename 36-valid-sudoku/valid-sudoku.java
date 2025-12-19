class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solver(board);
    }

    public boolean solver(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                if (!set.add(board[i][j] + "row" + i) ||
                        !set.add(board[i][j] + "cols" + j) ||
                        !set.add(board[i][j] + "box" + i / 3 + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}