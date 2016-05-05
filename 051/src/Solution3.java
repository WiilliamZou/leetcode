public class Solution3 {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }
        boolean[] hashRows = new boolean[n];
        boolean[] hashMajor = new boolean[2 * n - 1];
        boolean[] hashMinor = new boolean[2 * n - 1];
        search(board, 0, hashRows, hashMinor, hashMajor);
        return count;
    }

    private void search(int[] board, int row, boolean[] hashRows, boolean[] hashMinor, boolean[] hashMajor) {
        if (row == board.length) {
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            board[row] = j;
            if (!hashRows[board[row]] && !hashMinor[row + board[row]] && !hashMajor[row - board[row] + board.length - 1]) {
                hashRows[board[row]] = hashMinor[row + board[row]] = hashMajor[row - board[row] + board.length - 1] = true;
                search(board, row + 1, hashRows, hashMinor, hashMajor);
                hashRows[board[row]] = hashMinor[row + board[row]] = hashMajor[row - board[row] + board.length - 1] = false;
            }
            board[row] = -1;
        }
    }
}