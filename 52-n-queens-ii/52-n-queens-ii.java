class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        solve(grid, 0);
        return count;
    }
    
    
    private void solve(int[][] grid, int row){
        int n = grid.length;
        if(row==n){
            count++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(isValid(grid, row, i)){
                grid[row][i] = 1;
                solve(grid, row+1);
                grid[row][i] = 0;
            }
        }
    }
    
    private boolean isValid(int[][] grid, int x, int y){
        int n = grid.length;
        //checking up down
        for(int i = 0; i<n; i++){
            if(i==x)
                continue;
            if(grid[i][y]==1)
                return false;
        }
        
        //checking sideWays
        for(int i = 0; i<n; i++){
            if(i==y)
                continue;
            if(grid[x][i]==1)
                return false;
        }
        
        //checking upleft diagonal
        int i = x-1; int j = y-1;
        while(i>=0 && j>=0){
            if(grid[i--][j--] == 1)
                return false;
        }
        //checking downright diagonal
        i = x+1; j = y+1;
        while(i<n && j<n){
            if(grid[i++][j++] == 1)
                return false;
        }
        //checking upright
        i = x-1; j = y+1;
        while(i>=0 && j<n){
            if(grid[i--][j++] == 1)
                return false;
        }
        //checking downleft
        i= x+1; j= y-1;
        while(i<n && j>=0){
            if(grid[i++][j--] == 1)
                return false;
        }
        
        return true;
        
    }
}