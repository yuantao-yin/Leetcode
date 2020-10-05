package com.flang.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        // build graph
        for (int i = 0 ; i< numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }
        // add courses that have no prerequisites to the queue first
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int toTake : graph[cur]) {
                /* tart looping each neighbor of current course, decrease inDegree count by 1,
                   if inDegree count is 0, we know current course has no prerequiste course anymore,
                   (no more neighbor for current course),so we can add it to the queue
                */
                inDegree[toTake]--;
                if (inDegree[toTake] == 0) {
                    queue.offer(toTake);
                }
            }
        }
        for (int degree : inDegree) {
            if (degree != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] courseConn = {{1,2},{0,3},{1,4},{3,1}};
        System.out.println(CourseSchedule.canFinish(4, courseConn));
    }
}
