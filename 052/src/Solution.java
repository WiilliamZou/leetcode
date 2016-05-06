import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = solveNQueens(n);
        return result.size();
    }
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        dfs(new int[n], 0, result);
        return result;
    }

    private void dfs(int[] board, int i, ArrayList<List<String>> result) {
        int N = board.length;
        if (i == N) {
            addToList(board, result);
        } else {
            for (int move = 0; move < N; move++) {
                board[i] = move;
                if (goodMove(board, i)) {
                    dfs(board, i+1, result);
                }
            }
        }
    }

    private boolean goodMove(int[] board, int i) {
        for (int j = 0; j < i; j++) {
            if (board[i] == board[j] || Math.abs(board[i]-board[j]) == i-j) return false;
        }
        return true;
    }

    private void addToList(int[] board, ArrayList<List<String>> result) {
        List<String> current = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String line = "";
            for (int k = 0; k < board.length; k++) {
                if (board[k] == i) {
                    line += "Q";
                } else
                    line += ".";
            }
            current.add(line);
        }
        result.add(current);
    }
}