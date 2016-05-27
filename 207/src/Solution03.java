import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution03 {
    public boolean canFinish(int numCourses, int[][] prerequisties) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisties.length; i++) {
            int ready = prerequisties[i][0];
            int pre = prerequisties[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++;
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.remove();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
