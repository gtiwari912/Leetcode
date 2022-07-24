class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int row = findRow(matrix, 0, m, target);
        // System.out.println(row);
        for(int i = row; i>=0; i--){
            boolean cur = findCol(matrix, i, 0, n, target);
            if(cur)
                return cur;
        }
        // return findCol(matrix, row, 0, n, target);
        return false;
    }
    
    private int findRow(int[][] matrix, int low, int high, int target){
        // System.out.println("low:"+low+" high:"+high);
        if(low>high)
            return high;
        int mid = (low+high)/2;
        if(matrix[mid][0]==target)
            return mid;
        if(matrix[mid][0]<target)
            return findRow(matrix, mid+1, high, target);
        return findRow(matrix, low, mid-1, target);
    }
    
    private boolean findCol(int[][] matrix, int row, int low, int high, int target){
        // System.out.println("low:"+low+" high:"+high);
        if(low>high)
            return false;
        int mid = (low+high)/2;
        if(matrix[row][mid]==target)
            return true;
        if(matrix[row][mid]<target)
            return findCol(matrix, row, mid+1, high, target);
        return findCol(matrix, row, low, mid-1, target);
    }
}