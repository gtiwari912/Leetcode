class Solution {
    int[][] grid;
    int n;
    int m;
    HashMap<String, Integer> map;
    public int[] findBall(int[][] grid) {
        this.grid = grid;
        map = new HashMap<>();
        this.n = grid.length;
        this.m = grid[0].length;
        int[] ans = new int[m];
        for(int i = 0; i<m; i++){
            ans[i] = canReachEnd(0, i);
        }
        return ans;
    }
    
    public int canReachEnd(int x, int y){
        String str = x+","+y;
        if(map.containsKey(str)) return map.get(str);
        if(x>=n) return y;
        if((grid[x][y]==1 && y==m-1) || (grid[x][y]==-1 && y==0) 
          || (grid[x][y]==1 && grid[x][y+1]==-1) || (grid[x][y]==-1 && grid[x][y-1]==1))
            return -1;
        int ans = (grid[x][y]==1)? canReachEnd(x+1, y+1) : canReachEnd(x+1, y-1);
        map.put(str, ans);
        return ans;
    }
    
    
}