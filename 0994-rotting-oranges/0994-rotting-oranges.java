class Solution {

    class Pair{
        int x;
        int y;
        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "("+x+","+y+")";
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    Pair p = new Pair(i, j);
                    q.add(p);
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(q);
        int time =  0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair cur = q.remove();
                int x = cur.x;
                int y = cur.y;
                grid[x][y] = 2;
                for(int[] dir: dirs){
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if(newX>=0 && newX<m && newY>=0 && newY<n
                     && grid[newX][newY]==1 && !visited[newX][newY]){
                         Pair p = new Pair(newX, newY);
                         q.add(p);
                        visited[newX][newY] = true;
                     }
                }
            }
            System.out.println(q);
            time++;
        }
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(grid[i][j] == 1) {
                    System.out.println("Returning from here");
                    return -1;
                }
        return time==0? time:time-1;
    }
}