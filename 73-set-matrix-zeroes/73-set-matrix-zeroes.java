class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0; i<R; i++){
            for(int j =0; j<C; j++){
                if(matrix[i][j] == 0){
                    if(i==0) firstRow = true;
                    if(j==0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        
        for(int i = 1; i<R; i++){
            for(int j = 1; j<C; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRow){
            for(int i =0; i<C; i++)
                matrix[0][i] = 0;
        }
        
        if(firstCol){
            for(int i=0; i<R; i++){
                matrix[i][0] = 0;
            }
        }
    }
}