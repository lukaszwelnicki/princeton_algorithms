package unionfind;

public class QuickUnion implements UnionFind {

    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    @Override
    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if (rootp != rootq) {
            id[rootp] = rootq;
        }
    }

    private int findRoot(int p) {
        while (p != id[p]) {
            p = id[id[p]];
        }
        return p;
    }

}
