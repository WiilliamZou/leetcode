import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int M = 0;
    int N = 0;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        M = board.length;
        N = board[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O')
                queue.add(new Pair(i,0));
            if (board[i][N-1] == 'O')
                queue.add(new Pair(i,N-1));
        }
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                queue.add(new Pair(0, j));
            if (board[M-1][j] == 'O') {
                queue.add(new Pair(M-1,j));
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair curr = queue.remove();
                int x = curr.x;
                int y = curr.y;
                if (x >= 0 && x < M && y >= 0 && y < N && board[x][y] == 'O') {
                    board[x][y] = 'A';
                    queue.add(new Pair(x-1,y));
                    queue.add(new Pair(x+1,y));
                    queue.add(new Pair(x,y+1));
                    queue.add(new Pair(x,y-1));
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    class Pair {
        int x;
        int y;
        Pair(int x, int y) {this.x = x; this.y = y;};
    }
}