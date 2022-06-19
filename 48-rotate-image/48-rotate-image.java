class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix.length; j++){
                swap(matrix, i, j);
            }
        }
        
        for(int[] arr: matrix)
            System.out.println(Arrays.toString(arr));
        
        for(int i = 0; i<matrix.length; i++)
            reverse(matrix, i);
        
        
    }
    
    private void reverse(int[][] matrix, int i){
        int left = 0; 
        int right = matrix[0].length-1;
        while(left<right){
            swap(matrix, i, left, right);
            left++; right--;
        }
    }
    
    private void swap(int[][] matrix, int row, int i, int j){
        int temp = matrix[row][i];
        matrix[row][i] = matrix[row][j];
        matrix[row][j] = temp;
    }
    
    private void swap(int[][] matrix, int i , int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}