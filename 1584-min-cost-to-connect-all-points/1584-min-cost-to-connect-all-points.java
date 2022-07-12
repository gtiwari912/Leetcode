class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> edgesList = new ArrayList<>();
        int n = points.length;
        for(int i = 0; i<n; i++){
            int[] point1 = points[i];
            for(int j = i+1; j<n; j++){
                int[] point2 = points[j];
                int dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1]-point2[1]);
                int[] arr = {dist, i, j};
                edgesList.add(arr);
            }
        }
        Collections.sort(edgesList, (a,b)->Integer.compare(a[0], b[0]));
        // for(int[] now: edgesList)
            // System.out.println(Arrays.toString(now));
        UnionFind uf = new UnionFind(n);
        int mst = 0;
        int edgeUsed = 0;
        for(int i = 0; i<edgesList.size() && edgeUsed<n-1; i++){
            // System.out.println(uf);
            int[] edge = edgesList.get(i);
            if(uf.find(edge[1]) == uf.find(edge[2]))
                continue;
            else{
                uf.union(edge[1], edge[2]);
                mst += edge[0];
                edgeUsed++;
            }
            
        }
        
        return mst;
    }
}

class UnionFind{
    int num;
    int numComponents;
    int[] rank;
    int[] parent;
    
    @Override
    public String toString(){
        return Arrays.toString(parent);
    }

    UnionFind(int n){
        num = n; numComponents = n;
        rank = new int[n];
        Arrays.fill(rank, 0);
        parent = new int[n];
        for(int i = 0; i<n; i++)
            parent[i] = i;
    }
    
    int size(){return num;}
    
    int components(){return numComponents;}
    
    int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean isCycle(int[][] edgeList){
        for(int[] edge : edgeList){
            int v1 = edge[0];
            int v2 = edge[1];
            int root1 = find(v1);
            int root2 = find(v2);
            if(root1 == root2)
                return true;
            union(root1, root2);
        }
        return false;
    }
    
    public void union(int p, int q){
        int rootp = find(p); int rootq = find(q);
        if(rootp == rootq) return;
        if(rank[rootp] < rank[rootq]) parent[rootp] = rootq;
        else{
            parent[rootq] = rootp;
            if(rank[rootp] == rank[rootq]){rank[rootp]++;}
        }
        numComponents--;
    }
    
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    
}
// class UnionFind {
//     public int[] group;
//     public int[] rank;

//     public UnionFind(int size) {
//         group = new int[size];
//         rank = new int[size];
//         for (int i = 0; i < size; ++i) {
//             group[i] = i;
//         }
//     }

//     public int find(int node) {
//         if (group[node] != node) {
//             group[node] = find(group[node]);
//         }
//         return group[node];
//     }

//     public boolean union(int node1, int node2) {
//         int group1 = find(node1);
//         int group2 = find(node2);
        
//         // node1 and node2 already belong to same group.
//         if (group1 == group2) {
//             return false;
//         }

//         if (rank[group1] > rank[group2]) {
//             group[group2] = group1;
//         } else if (rank[group1] < rank[group2]) {
//             group[group1] = group2;
//         } else {
//             group[group1] = group2;
//             rank[group2] += 1;
//         }

//         return true;
//     }
// }