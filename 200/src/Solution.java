public class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return count;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return;
        if (j < 0 || j >= grid[i].length) return;
        if (grid[i][j] == '1') {
            grid[i][j] = 'x';
            dfs(grid, i+1,j);
            dfs(grid, i-1,j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
    }
}