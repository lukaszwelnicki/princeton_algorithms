package graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int sourceVertex;

    public DepthFirstPaths(Graph g, int sourceVertex) {
        this.marked = new boolean[g.getVerticesCount()];
        this.edgeTo = new int[g.getVerticesCount()];
        dfs(g, sourceVertex);
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = vertex; x != sourceVertex; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(sourceVertex);
        return path;
    }

    private void dfs(Graph g, int vertex) {
        marked[vertex] = true;
        for (int w : g.adjacent(vertex)) {
            if (!marked[w]) {
                dfs(g, w);
                edgeTo[w] = vertex;
            }
        }
    }
}
