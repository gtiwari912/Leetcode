class Solution {
    int grid[][];
    int rightBorder;
    int downBorder;
    int count;
    public int closedIsland(int[][] grid) {
        rightBorder = grid[0].length -1;
        downBorder = grid.length-1;
        this.grid = grid;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0 && !isBorderOrOutOfRange(i, j)){
                    if(recurse(i, j))
                        count++;
                }
            }
        }
        for(int[] cur: grid)
            System.out.println(Arrays.toString(cur));
        return count;
    }
    
    private boolean recurse(int i, int j){
        if(isBorderOrOutOfRange(i,j))
            return false;
        grid[i][j] = -1;
        boolean goUp=true, goDown=true, goRight=true, goLeft=true;
        if(grid[i-1][j] == 0)
            goUp = recurse(i-1, j);
        if(grid[i+1][j] == 0)
            goDown = recurse(i+1, j);
        if(grid[i][j+1] == 0)
            goRight = recurse(i, j+1);
        if(grid[i][j-1] == 0)
            goLeft = recurse(i, j-1);
        
        return (goUp && goDown && goRight && goLeft);
            
    }
    
    
    
    private boolean isBorderOrOutOfRange(int i, int j){
        return i<=0 || j <= 0 || i>=downBorder || j>=rightBorder;
    }
}

// class UnionFind{
//     int num;
//     int numComponents;
//     int[] rank;
//     int[] parent;

//     UnionFind(int n){
//         num = n; numComponents = n;
//         rank = new int[n];
//         Arrays.fill(rank, 0);
//         parent = new int[n];
//         for(int i = 0; i<n; i++)
//             parent[i] = i;
//     }
    
//     int size(){return num;}
    
//     int components(){return numComponents;}
    
//     int find(int p){
//         while(p != parent[p]){
//             parent[p] = parent[parent[p]];
//             p = parent[p];
//         }
//         return p;
//     }

//     public boolean isCycle(int[][] edgeList){
//         for(int[] edge : edgeList){
//             int v1 = edge[0];
//             int v2 = edge[1];
//             int root1 = find(v1);
//             int root2 = find(v2);
//             if(root1 == root2)
//                 return true;
//             union(root1, root2);
//         }
//         return false;
//     }
    
//     public void union(int p, int q){
//         int rootp = find(p); int rootq = find(q);
//         if(rootp == rootq) return;
//         if(rank[rootp] < rank[rootq]) parent[rootp] = rootq;
//         else{
//             parent[rootq] = rootp;
//             if(rank[rootp] == rank[rootq]){rank[rootp]++;}
//         }
//         numComponents--;
//     }
    
//     public boolean connected(int p, int q){
//         return find(p) == find(q);
//     }
    
// }