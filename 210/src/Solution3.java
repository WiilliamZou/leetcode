import java.util.ArrayList;
import java.util.Stack;

public class Solution3 {
    public int[] findOrder(int numCourses, int[][] prerequisite) {
        ArrayList<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisite.length; i++) {
            map[prerequisite[i][1]].add(prerequisite[i][0]);
        }

        int[] visitState = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        //Arrays.fill(visitState,0);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitState, stack))
                return new int[0];
        }
        int[] result = new int[numCourses];
        int i = 0;
        while (!stack.empty()) {
            result[i++] = stack.pop();
        }
        return result;
    }


    private boolean dfs(int n, ArrayList<Integer>[] map, int[] visitState, Stack<Integer> stack) {
        if (visitState[n] == 2)
            return true;
        if (visitState[n] == 1)
            return false;

        visitState[n] = 1;
        for (int j = 0; j < map[n].size(); j++) {
            if (!dfs(map[n].get(j), map, visitState, stack))
                return false;
        }
        stack.push(n);
        visitState[n] = 2;
        return true;
    }
}