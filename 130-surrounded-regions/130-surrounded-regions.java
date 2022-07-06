class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i<m; i++){
            if(board[i][0]=='O') dfs(board, i, 0);
            if(board[i][n-1]=='O') dfs(board, i, n-1);
        }
        
        for(int i = 0; i<n; i++){
            if(board[0][i]=='O') dfs(board, 0, i);
            if(board[m-1][i]=='O') dfs(board, m-1, i);
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else if(board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(board[i][j]=='O'){
            board[i][j] = '*';
            
            if(i>=1) dfs(board, i-1, j);
            if(i<=m-2) dfs(board, i+1, j);
            if(j>=1) dfs(board, i, j-1);
            if(j<=n-2) dfs(board, i, j+1);
        }
    }
}