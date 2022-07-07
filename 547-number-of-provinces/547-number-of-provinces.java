class Solution {
    int isConnected[][];
    int n;
    public int findCircleNum(int[][] isConneted) {
        int ans = 0;
        this.isConnected = isConneted;
        n = isConnected.length;
        int m = isConnected[0].length;
        for(int i = 0; i<n; i++){
            boolean sawNew = false;
            for(int j = 0; j<m; j++){
                if(isConnected[i][j]==1){
                    sawNew = true;
                    isConnected[i][j] = -1;
                    if(i!=j)
                        visitNeighbours(j);
                }
            }
            if(sawNew)
                    ans++;
        }
        
        return ans;
    }
    
    private void visitNeighbours(int r){
        // for(int[] cur: isConnected)
            // System.out.println(Arrays.toString(cur));
        // System.out.println("Visiting row: "+r);
        for(int i = 0; i<n; i++){
            if(isConnected[r][i]==1){
                isConnected[r][i] = -1;
                if(r!=i){
                    visitNeighbours(i);
                }
            }
        }
    }
}