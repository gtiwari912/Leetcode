class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n*n*4);
        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                char curChar = grid[i].charAt(j);
                int first = (i*n*4) + (j*4);
                int second = first+1;
                int third = first+2;
                int fourth = first+3;
                int[] leftUpRightDown = {-1,-1,-1,-1};
                if(i>0){
                    leftUpRightDown[1] = ((i-1)*n*4) + (j*4) + 3;
                }
                if(i<n-1){
                    leftUpRightDown[3] = ((i+1)*n*4) + (j*4) + 1;
                }
                if(j>0){
                    leftUpRightDown[0] = (i*n*4) + ((j-1)*4) + 2;
                }
                if(j<n-1){
                    leftUpRightDown[2] = (i*n*4) + ((j+1)*4);
                }
                
                if(curChar==' '){
                    uf.union(first, second);
                    uf.union(third, fourth);
                    uf.union(second, third);
                }
                else if(curChar == '/'){
                    uf.union(first, second);
                    uf.union(third, fourth);
                }
                else{
                    uf.union(first, fourth);
                    uf.union(second, third);
                }
                
                if(i>0){
                    uf.union(second, leftUpRightDown[1]);
                }
                if(i<n-1){
                    uf.union(fourth, leftUpRightDown[3]);
                }
                if(j>0){
                    uf.union(first, leftUpRightDown[0]);
                }
                if(j<n-1){
                    uf.union(third, leftUpRightDown[2]);
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