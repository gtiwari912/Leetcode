class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return recurse(0, 0, m-1, n-1);
    }
    
    private int recurse(int i, int j, int targetRow, int targetCol){
        if(i==targetRow || j==targetCol)
            return 1;
        
        if(memo[i][j] != 0)
            return memo[i][j];
        int left = recurse(i, j+1, targetRow, targetCol);
        int down = recurse(i+1, j, targetRow, targetCol);
        int ans = left+down;
        memo[i][j] = ans;
        return ans;
    }
}