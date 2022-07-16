class Solution {
    int[][][] memo;
    int M = 1000000007;
    int m;
    int n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove+1];
        this.m = m-1;
        this.n = n-1;
        for(int[][] grid: memo)
            for(int[] arr: grid)
                Arrays.fill(arr, -1);
        return recurse(startRow, startColumn, maxMove);
    }
    
    private int recurse(int i, int j, int mr){
        // System.out.println("IN i:"+i+" j:"+j+" moves:"+mr);
        if(outOfBound(i, j))
            return 1;
        if(mr<=0)
            return 0;
        if(memo[i][j][mr] != -1)
            return memo[i][j][mr];
        
        int ans = (((recurse(i+1, j, mr-1) + recurse(i-1, j, mr-1))%M + recurse(i, j+1, mr-1))%M+
            recurse(i, j-1, mr-1)) % M;
        memo[i][j][mr] = ans;
        return ans;
    }
    
    
    boolean isCorner(int i, int j){
        return ( (i==0) && (j==0) ) || ( (i==m) && (j==n) || (i==0 && j==n) || (i==m && j==0) );
    }
    
    boolean isEdge(int i, int j){
        return i==0 || i==m || j==0 || j==n;
    }
    
    boolean outOfBound(int i, int j){
        return i<0 || j<0 || i>m || j>n;
    }
}