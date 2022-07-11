class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i<grid1.length; i++){
            for(int j = 0; j<grid1[0].length; j++){
                if(grid2[i][j] == 1)
                    if(dfs(grid1, grid2, i, j, true))
                        count++;
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] A, int[][] B, int i, int j, boolean ans){
        int m = A.length; int n = A[0].length;
        if(i<0 || j<0 || i>=m || j>=n)
            return ans;
        B[i][j] = 0;
        if(A[i][j] == 0)
            ans = false;
        boolean b1=ans, b2=ans, b3=ans, b4=ans;
        if(i>0 && B[i-1][j] == 1)
            b1 = dfs(A, B, i-1, j, ans);
        if(i<m-1 && B[i+1][j] == 1)
            b2 = dfs(A, B, i+1, j, ans);
        if(j>0 && B[i][j-1] == 1)
            b3 = dfs(A, B, i, j-1, ans);
        if(j<n-1 && B[i][j+1]==1)
            b4 = dfs(A, B, i, j+1, ans);
        
        return ans && b1 && b2 && b3 && b4;
        
        
        
    }
}