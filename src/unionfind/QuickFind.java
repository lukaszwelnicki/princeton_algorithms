package unionfind;

public class QuickFind implements UnionFind {

    private int[] id;

    public QuickFind(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        if (idp != idq) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idp) id[i] = idq;
            }
        }
    }

}
