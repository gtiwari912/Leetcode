class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(exists(board, wordArray, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean exists(char[][] board, char[] word, int x, int y, int i){
        if(i==word.length)
            return true;
        int m = board.length-1;
        int n = board[0].length-1;
        if(x>m || y>n || x<0 || y<0)
            return false;
        if(board[x][y] != word[i])
            return false;
        char temp = board[x][y];
        board[x][y] = '.';
        boolean exist =  exists(board, word, x+1, y, i+1) ||
            exists(board, word, x-1, y, i+1) ||
            exists(board, word, x, y+1, i+1) ||
            exists(board, word, x, y-1, i+1);
        board[x][y] = temp;
        return exist;
    }
}