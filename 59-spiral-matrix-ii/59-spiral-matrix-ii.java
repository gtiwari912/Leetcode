class Solution {
    public int[][] generateMatrix(int n) {
        if(n==1){
            int[][] ans = new int[1][1];
            ans[0][0] = 1;
            return ans;
        }
        int[][] arr = new int[n][n];
        int iter = 1;
        HashSet<String> set = new HashSet<>();
        int RIGHT = 1;
        int DOWN = 2;
        int LEFT = 3;
        int UP = 4;
        int curDir = RIGHT;
        int curX=0;
        int curY = 0;
        boolean changed = true;
        while(true){
            if(set.contains(curX+","+curY))
                break;
            if(!changed)
                break;
            changed = false;
            System.out.println("currentDir:"+curDir);
            arr[curX][curY] = iter++;
            set.add(curX+","+curY);
            
            if(curDir==RIGHT){
                if(curY==n-1 || set.contains(curX+","+(curY+1))){
                    curX++;
                    curDir = DOWN;
                    changed = true;
                    continue;
                }
                else{
                    curY++;
                    changed = true;
                    continue;
                }
            }
            
            else if(curDir==DOWN){
                if(curX==n-1 || set.contains(curX+1+","+curY)){
                    curY--;
                    curDir = LEFT;
                    changed = true;
                    continue;
                }
                else{
                    curX++;
                    changed = true;
                    continue;
                }
            }
            
            else if(curDir==LEFT){
                if(curY==0 || set.contains(curX+","+(curY-1))){
                    curX--;
                    curDir = UP;
                    changed = true;
                    continue;
                }
                else{
                    curY--;
                    changed = true;
                    continue;
                }
            }
            
            else if(curDir==UP){
                if(curX==0 || set.contains((curX-1)+","+(curY))){
                    curY++;
                    curDir = RIGHT;
                    changed = true;
                    continue;
                }
                else{
                    curX--;
                    changed = true;
                    continue;
                }
            }
               
        }
        
        return arr;
        
    }
}