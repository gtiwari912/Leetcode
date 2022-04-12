class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] arr = new int[m][n];
        for(int i = 0;i<m; i++){
            for(int j =0; j<n; j++){
                int liveN = calcLiveN(board, i, j);
                // int deadN = 8 - liveN;
                // System.out.println("live n for row:"+i+" and col:"+j+" is "+liveN);
                if(liveN<2)
                    arr[i][j] = 0;
                else if((liveN==2||liveN==3) && board[i][j] == 1)
                    arr[i][j] = 1;
                else if(liveN>3)
                    arr[i][j] = 0;
                if(board[i][j] ==0 && liveN==3)
                    arr[i][j] = 1;
            }
        }
        
        for(int i = 0; i <m; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = arr[i][j];
            }
        }
            
    }
    
    private int calcLiveN(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        //above
        if(i>0 && board[i-1][j] ==1)
            count++;
        //down
        if(i<m-1 && board[i+1][j] ==1)
            count++;
        //right
        if(j<n-1 && board[i][j+1] == 1)
            count++;
        //left
        if(j>0 && board[i][j-1]==1)
            count++;
        
        //upleft
        if(i>0 && j>=1 && board[i-1][j-1]==1)
            count++;
        //upright
        if(i>0 && j<n-1 && board[i-1][j+1]==1)
            count++;
        //down left
        if(i<m-1 && j>0 && board[i+1][j-1]==1)
            count++;
        //downright
        if(i<m-1 && j<n-1 && board[i+1][j+1]==1)
            count++;
        
        return count;
        
    }
}