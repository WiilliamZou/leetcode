import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution05 {
    public boolean canFinish(int numCourses, int[][] prerequisite) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisite.length; i++) {
            map[prerequisite[i][1]].add(prerequisite[i][0]);
        }

        int[] visitState = new int[numCourses];
        //Arrays.fill(visitState,0);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitState))
                return false;
        }
        return true;
    }

    private boolean dfs(int n, ArrayList<Integer>[] map, int[] visitState) {
        if (visitState[n] == 2)
            return true;
        if (visitState[n] == 1)
            return false;

        visitState[n] = 1;
        for (int j = 0; j < map[n].size(); j++) {
            if (!dfs(map[n].get(j), map, visitState))
                return false;
        }

        visitState[n] = 2;
        return true;
    }
}
