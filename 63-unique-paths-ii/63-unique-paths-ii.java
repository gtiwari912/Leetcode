class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++) for(int j = 0; j<n; j++) dp[i][j] = -1;
        return solve(grid, dp, 0, 0);
    }
    
    private int solve(int[][] grid, int[][] dp, int x, int y){
        int rowLimit = grid.length -1;
        int colLimit = grid[0].length - 1;
        if(x>rowLimit || y>colLimit) return 0;
        if(grid[x][y] == 1) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        if(x==rowLimit && colLimit==y) return 1;
        return dp[x][y] = solve(grid, dp, x+1, y) + solve(grid, dp, x, y+1);
    }
}