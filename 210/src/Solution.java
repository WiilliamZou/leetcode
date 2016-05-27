import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        int count = 0;
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        List<Integer>[] adjacentList = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int ready = edges[i][0];
            int pre = edges[i][1];
            if (!adjacentList[pre].contains(ready)) {
                adjacentList[pre].add(ready);
                indegree[ready]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]== 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.remove();
            result[count++] = course;
            for (int i = 0; i < adjacentList[course].size(); i++) {
                int next = adjacentList[course].get(i);
                if (--indegree[next] == 0)
                    queue.add(next);
            }
        }
        return (count == numCourses) ? result: new int[0];
    }
}