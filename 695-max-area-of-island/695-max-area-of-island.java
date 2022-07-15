class Solution {
    int[][] grid;
    int r, c;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;
        
        int maxArea = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j]==1){
                    count=0;
                    int curArea = calcArea(i, j);
                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    
    private int calcArea(int i, int j){
        count++;
        grid[i][j] = -1;
        
//         UP-DOWN;
        if(i>=1 && grid[i-1][j]==1)
            calcArea(i-1, j);
        if(i<=r-2 && grid[i+1][j]==1)
            calcArea(i+1, j);
        
//         LEFT-RIGHT;
        if(j>=1 && grid[i][j-1]==1)
            calcArea(i, j-1);
        if(j<=c-2 && grid[i][j+1]==1)
            calcArea(i, j+1);
        
        return count;
        
    }
}