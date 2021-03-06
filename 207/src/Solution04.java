import java.util.ArrayList;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution04 {
    public boolean canFinish(int numCourses, int[][] prerequisties) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisties.length; i++) {
            graph[prerequisties[i][1]].add(prerequisties[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course])
            return false;
        else
            visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }
}
