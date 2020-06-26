package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int verticesCount;
    private List<Integer>[] adjacent;

    public Graph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjacent = (LinkedList<Integer>[]) new LinkedList[verticesCount];
        for (int v = 0; v < verticesCount; v++) {
            adjacent[v] = new LinkedList<>();
        }
    }

    public static int degree(Graph g, int vertex) {
        int degree = 0;
        for (int w : g.adjacent(vertex)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.verticesCount; v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }
        return max;
    }

    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.verticesCount; v++) {
            for (int w : g.adjacent(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public void addEdge(int firstVertex, int secondVertex) {
        adjacent[firstVertex].add(secondVertex);
        adjacent[secondVertex].add(firstVertex);
    }

    public Iterable<Integer> adjacent(int vertex) {
        return adjacent[vertex];
    }

    public int getVerticesCount() {
        return verticesCount;
    }
}
