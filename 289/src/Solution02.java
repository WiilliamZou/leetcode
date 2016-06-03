/**
 * Created by yunxiaozou on 6/3/16.
 */
public class Solution02 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int k = 0; k < 9; k++) {
                    int row = k/3 - 1 + i;
                    int col = k%3 - 1 + j;
                    if (row < 0 || row >= board.length)
                        continue;
                    if (col < 0 || col >= board[0].length)
                        continue;
                    if (row == i && col == j)
                        continue;
                    if (board[row][col] == 1 || board[row][col] == 2) live++;
                }
                if (board[i][j] == 0 && live == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;

            }

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
