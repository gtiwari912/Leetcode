class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        int m =  matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        isFirstRowZero=true;
                        // matrix[0][j] = 0;
                    }
                    else{
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        //going for cols;
        for(int i = 0; i<n; i++){
            if(matrix[0][i]==0){
                stack.add(-i);
            }
        }
        
        //going for row;
        if(isFirstRowZero)
            stack.add(201);
        for(int i=1; i<m; i++){
            if(matrix[i][0] == 0)
                stack.add(i);
        }
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(cur==201){
                setRowZero(matrix, 0);
            }
            else if(cur>0){
                setRowZero(matrix, cur);
            }
            else{
                setColZero(matrix, -cur);
            }
        }
    }
    
    
    private void setRowZero(int[][] matrix, int row){
        for(int i= 0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    
    private void setColZero(int[][] matrix, int col){
        for(int i = 0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}