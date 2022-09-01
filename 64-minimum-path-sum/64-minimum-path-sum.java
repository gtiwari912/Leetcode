class Solution {
    int destRow;
    int destCol;
    int[][] grid;
    long[][] dp;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        destRow = grid.length - 1;
        destCol = grid[0].length - 1;
        dp = new long[grid.length][grid[0].length];
        for(long[] arr: dp) for(int i =0; i<arr.length; i++) arr[i] = -1;
        return (int) solve(0, 0);
    }
    
    private long solve(int x, int y){
        if(x==destRow && y==destCol)
            return grid[x][y];
        if(x>destRow || y>destCol)
            return Integer.MAX_VALUE;
        if(dp[x][y] != -1)
            return dp[x][y];
        int cur = grid[x][y];
        return dp[x][y] = Math.min(
            cur + solve(x+1, y),
            cur + solve(x, y+1)
        );
    }
}