import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yunxiaozou on 6/6/16.
 */
public class Solution03 {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reachCount = new int[m][n];
        int houseCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houseCount++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, distance, reachCount, houseCount, m, n, i, j)) {
                        return -1;
                    }
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == houseCount) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE? -1 : minDistance;
    }

    private boolean bfs(int[][] grid, int[][] distance, int[][] reachCount, int houseCount, int m, int n, int x, int y) {
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int level = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = curr[0] + dx[k];
                    int ny = curr[1] + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && visited[nx][ny] == 0) {
                        if (grid[nx][ny] == 0) {
                            distance[nx][ny] += level;
                            visited[nx][ny] = 1;
                            reachCount[nx][ny]++;
                            q.add(new int[]{nx, ny});
                        } else if (grid[nx][ny] == 1) {
                            count++;
                            visited[nx][ny] = 1;
                        }
                    }
                }
                return count == houseCount; // all the houses must be connected.
            }
        }
    }
}
