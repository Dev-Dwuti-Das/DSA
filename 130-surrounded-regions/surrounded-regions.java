class Solution {

    //EASY QUESTION H KHUD SE KR
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length - 1, board);
        }

        for (int j = 0; j < board[0].length; j++) {
            dfs(0, j, board);
            dfs(board.length - 1, j, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }

}