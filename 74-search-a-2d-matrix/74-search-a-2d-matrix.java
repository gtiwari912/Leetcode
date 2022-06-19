class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binSearch(matrix, target);
    }
    
    private boolean binSearch(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/n;
            int col = mid%n;
            int midEle = matrix[row][col];
            //System.out.println("mid:"+mid+" midEle:"+midEle);
            if(midEle==target)
                return true;
            if(midEle>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return false;
    }
}