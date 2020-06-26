package graph;

public class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int componentsCount;

    public ConnectedComponents(Graph g) {
        this.marked = new boolean[g.getVerticesCount()];
        this.id = new int[g.getVerticesCount()];
        for (int v = 0; v < g.getVerticesCount(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                componentsCount++;
            }
        }
    }

    public int id(int vertex) {
        return id[vertex];
    }

    public int getComponentsCount() {
        return componentsCount;
    }

    private void dfs(Graph g, int vertex) {
        marked[vertex] = true;
        id[vertex] = componentsCount;
        for (int w : g.adjacent(vertex)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
}
