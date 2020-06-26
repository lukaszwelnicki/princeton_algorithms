package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPaths(Graph g, int sourceVertex) {
        this.marked = new boolean[g.getVerticesCount()];
        this.edgeTo = new int[g.getVerticesCount()];
        bfs(g, sourceVertex);
    }

    private void bfs(Graph g, int sourceVertex) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(sourceVertex);
        marked[sourceVertex] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : g.adjacent(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
