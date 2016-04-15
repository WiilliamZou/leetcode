/**
 * Created by yunxiaozou on 4/15/16.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows and columns;
        for (int i = 0; i < board.length; i++) {
            char[] row = new char[9];
            char[] column = new char[9];
            for (int j = 0; j < board[i].length; j++) {
                row[j] = board[i][j];
                row[j] = board[j][i];
            }
            if (!isValidSection(row) || !isValidSection(column))
                return false;
        }

        //check sections
        for (int i = 0; i < 9; i++) {
            char[] section = new char[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    section[j * 3 + k] = board[(i/3) * 3 + j][(i%3) * 3 + k];
                }
            }
            if (!isValidSection(section))
                return false;
        }
        return true;
    }
    public boolean isValidSection(char[] array) {
        boolean[] flag = new boolean[10];
        for (char c : array) {
            if (c == '.') continue;
            else if (!Character.isDigit(c)) return false;
            else {
                if (flag[c-'0']) return false;
                flag[c-'0'] = true;
            }
        }
        return true;
    }
}