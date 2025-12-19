class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;
                for (int val = 1; val < 10; val++) {
                    if (isvalid(board, val, i, j)) {
                        board[i][j] =  (char)(val+'0');
                        if (backtrack(board)) {
                            return true;
                        }else{
                            board[i][j] = '.';
                        }
                        
                    }
                }
                return false; //yeah hi important bs baki to khud se ho jyega 
            }
        }
        return true;
    }

    public boolean isvalid(char[][] board, int val, int k, int l) {
        Character ch = (char)(val+'0'); 
        for (int i = 0; i < 9; i++) {
            if (board[k][i] == ch)
                return false;
            if (board[i][l] == ch)
                return false;
            if (board[3 * (k / 3) + i / 3][3 * (l / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }
}