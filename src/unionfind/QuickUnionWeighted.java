package unionfind;

public class QuickUnionWeighted implements UnionFind {

    private int[] id;
    private int[] weight;

    public QuickUnionWeighted(int n) {
        id = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            weight[i] = 1;
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
            int weightp = weight[rootp];
            int weightq = weight[rootq];
            if (weightp < weightq) {
                id[rootp] = rootq;
                weight[rootq] += weight[rootp];
            } else {
                id[rootq] = rootp;
                weight[rootp] += weight[rootq];
            }
        }
    }

    private int findRoot(int p) {
        while (p != id[p]) {
            p = id[id[p]];
        }
        return p;
    }

}
