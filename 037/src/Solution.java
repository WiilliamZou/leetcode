public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private void dfs(char[][] board, int k) {
        if (k == 81)
            return;
        int i = k/9, j = k%9;
        if (board[i][j] != '.') dfs(board, k+1);
        for (char c = '1'; c <= '9'; c++) {
            board[i][j] = c;
            if(validate(board, k)) dfs(board,k+1);
            board[i][j] = '.';
        }
    }
    private boolean validate(char[][] board, int k) {
        boolean[] flag = new boolean[9];
        int i = k/9, j = k%9;
        for (int l = 0; l < 9; l++) {
            if (Character.isDigit(board[i][l])) {
                if (flag[board[i][l]-'1']) {
                    return false;
                }
                flag[board[i][l]-'1'] = true;
            }
        }
        flag = new boolean[9];
        for (int l = 0; l < 9; l++) {
            if (Character.isDigit(board[l][j])) {
                if (flag[board[l][j]-'1']) {
                    return false;
                }
                flag[board[l][j]-'1'] = true;
            }
        }
        flag = new boolean[9];
        int is = i - (i%3), js = j - (j%3);
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                if (Character.isDigit(board[is+l][js+m])) {
                    if (flag[board[is+l][js+m]-'1']) {
                        return false;
                    }
                    flag[board[is+l][js+m]-'1'] = true;
                }
            }
        }
        return true;
    }
}