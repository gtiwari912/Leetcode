class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(entrance);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.remove();
                int x = cur[0];
                int y = cur[1];
                maze[x][y] = 'v';
                if((x==0 || x==maze.length-1 || y==0 || y==maze[0].length-1) && !(x== entrance[0]&&y==entrance[1]))
                    return count;
                //right
                if(y<maze[0].length-1 && maze[x][y+1]=='.'){
                    q.add(new int[]{x,y+1});
                    maze[x][y+1] = 'v';
                }
                if(y>0 && maze[x][y-1]=='.'){
                    q.add(new int[]{x, y-1});
                    maze[x][y-1] = 'v';
                }
                if(x<maze.length-1 && maze[x+1][y]=='.'){
                    q.add(new int[]{x+1,y});
                    maze[x+1][y] = 'v';
                }
                if(x>0 && maze[x-1][y]=='.'){
                    q.add(new int[]{x-1, y});
                    maze[x-1][y] = 'v';
                }
            }
            count++;
        }
        return -1;
    }
}