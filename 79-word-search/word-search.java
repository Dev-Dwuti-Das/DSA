class Solution {
    public boolean exist(char[][] board, String word) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (j < 0 || j >= board[0].length || i < 0 || i >= board.length || board[i][j] == '0') {
            return false;
        }
        if (board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = '0';

        boolean res = dfs(i, j + 1, board, word, idx + 1) || dfs(i, j - 1, board, word, idx + 1)
                || dfs(i + 1, j, board, word, idx + 1) || dfs(i - 1, j, board, word, idx + 1);

        board[i][j] = temp;

        return res;
    }
}