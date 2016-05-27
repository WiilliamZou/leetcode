import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution5 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) { // pre -> vertex
            map[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visitState = new int[numCourses];
        Arrays.fill(visitState, 0); // 0: unvisited, 1: visiting, 2:visited

        for (int i = 0; i < numCourses; i++) {
            if (!DFSVisit(i, map, visitState))
                return false;
        }
        return true;
    }

    private static boolean DFSVisit(int n, ArrayList<Integer>[] map, int[] visitState) {
        if (visitState[n] == 2)
            return true;
        if (visitState[n] == 1)
            return false;

        visitState[n] = 1;
        for (int j = 0; j < map[n].size(); j++) {
            if (!DFSVisit(map[n].get(j), map, visitState))
                return false;
        }
        visitState[n] = 2;
        return true;
    }
}
