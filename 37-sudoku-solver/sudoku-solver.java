class Solution {
  public void solveSudoku(char[][] board) {
    solve(board);
  }

  public boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char num = '1'; num <= '9'; num++) {
            if (isvalid(i, j, board, num)) {
              board[i][j] = num;

              if(solve(board)) return true;

              board[i][j] = '.';
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public boolean isvalid(int row, int col, char[][] board, char num) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num) {
        return false;
      }
      if (board[row][i] == num) {
        return false;
      }
      int x = 3 * (row / 3) + i / 3;
      int y = 3 * (col / 3) + i % 3;
      if (board[x][y] == num)
        return false;
    }
    return true;
  }
}
