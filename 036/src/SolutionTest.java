import static junit.framework.Assert.*;

/**
 * Created by yunxiaozou on 4/15/16.
 */
public class SolutionTest {
    @org.junit.Test
    public void isValidSudoku() throws Exception {

        String[] testString = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char[][] test = convert(testString);
        Solution sol = new Solution();
        assertTrue(sol.isValidSudoku(test));
    }

    public char[][] convert(String[] strings) {
        char[][] test = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test[i][j] = strings[i].charAt(j);
            }
        }
        return test;
    }

}