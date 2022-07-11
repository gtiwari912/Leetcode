class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        UnionFind uf = new UnionFind(grid);
        // System.out.println(uf.components());
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    int idx = i*n+j;
                    for(int[] arr: dir){
                        int x = i+arr[0];
                        int y = j+arr[1];
                        if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1'){
                            // System.out.println("Doing union");
                            int newIdx = x*n+y;
                            uf.union(idx, newIdx);
                        }
                    }
                }
            }
        }
        
        return uf.components();
    }
}


class UnionFind{
    int num;
    int numComponents;
    int[] rank;
    int[] parent;

    UnionFind(char[][] grid){
        // num = n; numComponents = n;
        // rank = new int[n];
        // Arrays.fill(rank, 0);
        // parent = new int[n];
        // for(int i = 0; i<n; i++)
            // parent[i] = i;
        int n = grid.length; 
        int m = grid[0].length;
        parent = new int[n*m];
        for(int i=0; i<n;i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    int idx = i*m + j;
                    parent[idx] = idx;
                    numComponents++;
                }
            }
        }
        num = numComponents;
        rank = new int[m*n];
        Arrays.fill(rank, 0);
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