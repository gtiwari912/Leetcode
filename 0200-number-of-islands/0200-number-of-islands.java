class Solution {
    int[][] mat;
    int limitRow;
    int limitCol;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        mat = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1') mat[i][j] = 1;
                else mat[i][j] = 0;
            }
        }
        limitRow = m-1;
        limitCol = n-1;
        int count = 0;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(mat[i][j] == 1){
                    bfs(i, j);
                    count++;
                }
        return count;
    }
    
    public void bfs(int i, int j){
        if(i<0 || j<0 || i>limitRow || j>limitCol) return;
        if(mat[i][j] == 0) return;
        mat[i][j] = 0;
        bfs(i+1, j);
        bfs(i-1, j);
        bfs(i, j+1);
        bfs(i, j-1);
    }
}