package com.flang.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // build graph
        for (int pair[] : prerequisites) {
            int pre = pair[1];
            int cur = pair[0];
            graph[pre].add(cur);
            inDegree[cur]++;
        }
        // store courses that have no prerequisites
        int visited = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            // the course is visited
            visited++;
            // loop current course's prerequisites
            for (Integer child : graph[cur]) {
                inDegree[child]--;
                // if inDegree is 0, push to the queue
                if (inDegree[child] == 0) {
                    queue.offer(child);
                }
            }

        }

        return visited == numCourses;

    }
}
