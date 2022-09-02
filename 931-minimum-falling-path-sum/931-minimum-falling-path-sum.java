class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<n; j++){
                int cur = matrix[i][j];
                int bottom = cur + matrix[i+1][j];
                int left = (j==0)? Integer.MAX_VALUE - 1000: cur + matrix[i+1][j-1];
                int right = (j==n-1)? Integer.MAX_VALUE - 1000: cur + matrix[i+1][j+1];
                matrix[i][j] = Math.min(left, Math.min(right, bottom));
            }
        }
        
        int ans = Integer.MAX_VALUE - 1000;
        for(int i = 0; i<n; i++){
            ans = Math.min(matrix[0][i], ans);
        }
        
        return ans;
    }
}