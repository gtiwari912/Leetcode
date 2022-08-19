class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for(int i = 1; i<=n-2; i++){
            for(int j = 1; j<=n-2; j++){
                int max = 0;
                for(int row = i-1; row<=i+1; row++){
                    for(int col = j-1; col<=j+1; col++)
                        max = Math.max(max, grid[row][col]);
                }
                res[i-1][j-1] = max;
                
            }
        }
        
        
        return res;
    }
}