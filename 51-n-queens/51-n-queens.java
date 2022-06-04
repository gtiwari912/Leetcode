//just copy pasted from previously done solution

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid= new char[n][n];
        for(int i = 0; i<n; i++)
            for(int j =0; j<n; j++)
                grid[i][j] = '.';
        List<List<String>> ans = new ArrayList<>();
        dfs(grid, 0, ans);
        return ans;
    }
    
    private void dfs(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row==n){
            ans.add(takeSnapshot(board));
            return;
        }
        for(int i =0; i<n; i++){
            boolean isVal = isValid(board, row, i);
            if(isVal){
                board[row][i] = 'Q';
                dfs(board, row+1, ans);
                board[row][i] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] grid, int row, int col){
        int dupRow = row;
        int dupCol = col;
        while(row>=0){
            if(grid[row][col]=='Q')
                return false;
            row--;
        }
        row = dupRow;
        while(row>=0 && col>=0){
            if(grid[row][col]=='Q')
                return false;
            row--; col--;
        }
        row = dupRow;
        col = dupCol;
        while(row>=0 && col<grid.length){
            if(grid[row][col]=='Q')
                return false;
            row--; col++;
        }
        return true;
    }

    private List<String> takeSnapshot(char[][] board){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        return list;
    }
}