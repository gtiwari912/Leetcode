class Solution {
    int lastRow;
    int lastCol;
    public boolean exist(char[][] board, String word) {
        lastRow = board.length - 1;
        lastCol = board[0].length - 1;
        for(int i = 0; i<=lastRow; i++){
            for(int j = 0; j<=lastCol; j++){
                if(helper(board, new int[]{-1,-1}, new int[]{i,j}, 0, word)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int[] prev, int[] cur, int index, String word){
        if(index==word.length()) return true;
        if(cur[0]<0 || cur[1]<0 || cur[0]>lastRow || cur[1]>lastCol) return false;
        char curChar = board[cur[0]][cur[1]];
        char reqChar = word.charAt(index);
        if(reqChar != curChar) return false;
        char temp = board[cur[0]][cur[1]];
        board[cur[0]][cur[1]] = '.';
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean ans = false;
        for(int[] newDir: dirs){
            newDir[0] += cur[0];
            newDir[1] += cur[1];
            if(newDir[0]==prev[0] && newDir[1]==prev[1]) continue;
            ans = ans || helper(board, cur, newDir, index+1, word);
            if(ans) return ans;
        }
        board[cur[0]][cur[1]] = temp;
        return ans;
    }
}