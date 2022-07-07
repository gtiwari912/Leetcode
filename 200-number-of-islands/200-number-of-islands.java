class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                // String str = i+","+j;
                int cur = grid[i][j];
                if(cur=='1'){
                    // System.out.println("IN Loop for: "+i+","+j);
                    // visited.contains(str)
                        // continue;
                    // visited.add(str);
                    
                    if(i-1>=0 && grid[i-1][j]=='1'){
                        uf.union(i*n+j, (i-1)*n+j);
                    }
                    if(i+1<m && grid[i+1][j] == '1'){
                        uf.union(i*n+j, (i+1)*n+j);
                    }
                    if(j-1>=0 && grid[i][j-1]=='1'){
                        uf.union(i*n+j, i*n+(j-1));
                    }
                    if(j+1<n && grid[i][j+1]=='1'){
                        uf.union(i*n+j, i*n+(j+1));
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
        // num = n; 
        numComponents = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[n*m];
        rank = new int[n*m];
        Arrays.fill(rank, 0);
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    numComponents++;
                    parent[i*n + j] = i*n+j;
                }
            }
        }
        // System.out.println(Arrays.toString(parent));
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