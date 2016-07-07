import static org.junit.Assert.*;

/**
 * Created by yunxiaozou on 7/4/16.
 */
public class Solution2Test {
    @org.junit.Test
    public void numIslands() throws Exception {
        String[] gridString = {"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
        char[][] grid = new char[gridString.length][gridString[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = gridString[i].charAt(j);
            }
        }
        Solution2 sol = new Solution2();
        System.out.println(sol.numIslands(grid));
    }

}