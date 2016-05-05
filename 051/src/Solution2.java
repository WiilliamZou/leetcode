
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        enumerate(n, result);
        return result;
    }
    public void enumerate(int n, List<String[]> result) {
        int[] a = new int[n];
        enumerate(a,0, result);
    }
    public void enumerate(int[] q, int n, List<String[]> result) {
        int N = q.length;
        if (n == N)  addToList(q, result);
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n)) enumerate(q, n+1, result);
            }
        }
    }
    private boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }
    private void addToList(int[] q, List<String[]> result) {
        String[] board = new String[q.length];
        for(int i = 0; i < q.length; i++) {
            String line = "";
            for (int j = 0; j < q.length; j++) {
                if (q[i] == j) line += "Q";
                else line += ".";
            }
            board[i] = line;
            System.out.println(line);
        }

        result.add(board);
        System.out.println("--------------------");


    }

    public static void main(String[] args) {
        Solution sol2 = new Solution();
        List<String[]> list = sol2.solveNQueens(8);
        for(String[] board : list)
        {
            for (String line : board)
                System.out.println(line);
            System.out.println();
        }
    }

}
