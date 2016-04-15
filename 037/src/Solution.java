import java.util.Arrays;
public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private boolean dfs(char[][] board, int k) {
        if (k == 81) return true;
        int i = k/9, j = k%9;
        if (board[i][j] != '.') return dfs(board, k+1);
        boolean[] flag = new boolean[10];
        findCandidate(board, i, j, flag);
        for (int index = 1; index <= 9; index++) {
            if (flag[index]) {
                board[i][j] = (char)('0' + index);
                if(dfs(board,k+1)) return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    private void findCandidate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') flag[board[i][k] - '0'] = false;
            if (board[k][j] != '.') flag[board[k][j] - '0'] = false;

            int r = i/3*3 + k/3;
            int c = j/3*3 + k%3;
            if (board[r][c] != '.') flag[board[r][c] - '0'] = false;
        }
    }

}