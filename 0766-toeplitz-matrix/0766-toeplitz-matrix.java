class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int j = 0; j<matrix[0].length; j++){
            if(  !helper(0, j, matrix[0][j], matrix)   )
                return false;
        }
        
        for(int i = 0; i<matrix.length; i++){
            if(  !helper(i, 0, matrix[i][0], matrix)   )
                return false;
        }
        
        return true;
        
    }
    
    
    public boolean helper(int i, int j, int element, int[][] matrix){
        while(i<matrix.length && j<matrix[0].length){
            if(matrix[i][j] != element) return false;
            i++;
            j++;
        }
        return true;
    }
}