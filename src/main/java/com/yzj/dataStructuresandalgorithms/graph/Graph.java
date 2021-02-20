package com.yzj.dataStructuresandalgorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description: 有向图
 * @author: blessing
 * @create: 2020-06-04 15:58
 */
public class Graph {
    private int vertexCount;
    private LinkedList<Integer>[] adj;
    private boolean found;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        adj[start].add(end);
    }

    public void bfs(int start, int end) {
        if (start == end) return;
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] prev = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < adj[cur].size(); i++) {
                int q = adj[cur].get(i);
                if (!visited[q]) {
                    prev[q] = cur;
                    if (q == end) {
//                        print
                        print(prev, start, end);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int start, int end) {
        if (prev[end] != -1 && start != end) {
            print(prev, start, prev[end]);
        }
        System.out.print(end + "->");
    }

    public void dfs(int start, int end) {
        found = false;
        boolean[] visited = new boolean[vertexCount];
        int[] prev = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            prev[i] = -1;
        }
        recursionDfs(start, end, visited, prev);
        print(prev, start, end);
    }

    private void recursionDfs(int cur, int end, boolean[] visited, int[] prev) {
        if (found) return;
        visited[cur] = true;
        if (cur == end) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[cur].size(); i++) {
            int q = adj[cur].get(i);
            if (!visited[q]) {
                prev[q] = cur;
                recursionDfs(q, end, visited, prev);
            }
        }
    }

    public static void main(String[] args) {
//        有向图
//        0 → 1 → 2
//        ↓   ↓   ↓
//        3 → 4 → 5
//            ↓   ↓
//            6 → 7
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

//        bfs测试
        graph.bfs(0, 7);
        System.out.println();

//        dfs测试
        graph.dfs(0, 7);
    }
}
